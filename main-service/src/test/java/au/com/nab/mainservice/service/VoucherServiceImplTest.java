package au.com.nab.mainservice.service;

import static org.assertj.core.api.Fail.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import au.com.nab.mainservice.client.VoucherClient;
import au.com.nab.mainservice.client.SmsClient;
import au.com.nab.mainservice.dto.GetVoucherResponse;
import au.com.nab.mainservice.dto.VoucherRequest;
import au.com.nab.mainservice.dto.VoucherResponse;
import au.com.nab.mainservice.entity.Token;
import au.com.nab.mainservice.entity.Voucher;
import au.com.nab.mainservice.exception.TokenNotFoundException;
import au.com.nab.mainservice.repository.VoucherRepository;
import au.com.nab.mainservice.service.impl.TokenServiceImpl;
import au.com.nab.mainservice.service.impl.VoucherServiceImpl;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

public class VoucherServiceImplTest {

    private VoucherService voucherService;
    private TokenService tokenService;
    private VoucherRepository voucherRepository;
    private VoucherClient voucherClient;

    @Before
    public void init() {
        tokenService = Mockito.mock(TokenServiceImpl.class);
        voucherRepository = Mockito.mock(VoucherRepository.class);
        voucherClient = Mockito.mock(VoucherClient.class);
        voucherService = new VoucherServiceImpl(tokenService, voucherRepository, voucherClient);
    }

    @Test
    public void createVoucher() {
        VoucherRequest voucherRequest = new VoucherRequest();
        voucherRequest.setPhoneNumber("123");
        voucherRequest.setVoucherServiceToken("456");
        au.com.nab.mainservice.client.dto.VoucherResponse externalVoucherResponse = new au.com.nab.mainservice.client.dto.VoucherResponse();
        externalVoucherResponse.setCode("789");
        externalVoucherResponse.setExpiration(new Date());
        when(voucherClient.createVoucher(any())).thenReturn(externalVoucherResponse);
        VoucherResponse voucherResponse = voucherService.createVoucher(voucherRequest);
        ArgumentCaptor<Voucher> voucherArgumentCaptor = ArgumentCaptor.forClass(Voucher.class);
        verify(voucherRepository).saveAndFlush(voucherArgumentCaptor.capture());
        Voucher savedVoucher = voucherArgumentCaptor.getValue();
        assertEquals(externalVoucherResponse.getCode(), savedVoucher.getCode());
        assertEquals(externalVoucherResponse.getExpiration(), savedVoucher.getExpirationDate());
        assertEquals(voucherRequest.getPhoneNumber(), savedVoucher.getPhoneNumber());
        assertEquals(externalVoucherResponse.getCode(), voucherResponse.getVoucherCode());
        assertEquals(externalVoucherResponse.getExpiration(), voucherResponse.getExpirationDate());
        assertEquals("Valid", voucherResponse.getStatus());
    }

    @Test
    public void getVouchers_TokenNotFound() {
        Token token = new Token();
        token.setPhoneNumber("123");
        token.setEncryptedToken("123");
        Optional<Token> optionalToken = Optional.empty();
        when(tokenService.find(any(), any(), any())).thenReturn(optionalToken);
        List<Voucher> vouchers = new ArrayList<>();
        Voucher voucher = new Voucher();
        voucher.setPhoneNumber("123");
        voucher.setExpirationDate(new Date());
        voucher.setCode("abc");
        vouchers.add(voucher);
        when(voucherRepository.findAllByPhoneNumber(any())).thenReturn(vouchers);
        try {
            voucherService.getVouchers("123", "123", "123");
            fail("Exception must be thrown");
        } catch (Exception tokenNotFoundException) {
            assertTrue(tokenNotFoundException instanceof TokenNotFoundException);
        }
    }

    @Test
    public void getVouchers() {
        Token token = new Token();
        token.setPhoneNumber("123");
        token.setEncryptedToken("123");
        Optional<Token> optionalToken = Optional.of(token);
        when(tokenService.find(any(), any(), any())).thenReturn(optionalToken);
        List<Voucher> vouchers = new ArrayList<>();
        Voucher voucher = new Voucher();
        voucher.setPhoneNumber("123");
        voucher.setExpirationDate(new Date());
        voucher.setCode("abc");
        vouchers.add(voucher);
        when(voucherRepository.findAllByPhoneNumber(any())).thenReturn(vouchers);
        List<GetVoucherResponse> voucherResponses = voucherService.getVouchers("123", "123", "123");
        assertEquals(1, voucherResponses.size());
        GetVoucherResponse getVoucherResponse = voucherResponses.get(0);
        assertEquals(voucher.getCode(), getVoucherResponse.getVoucherCode());
    }
}
