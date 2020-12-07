package au.com.nab.mainservice.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import au.com.nab.mainservice.dto.GetVoucherRequest;
import au.com.nab.mainservice.dto.GetVoucherResponse;
import au.com.nab.mainservice.entity.Token;
import au.com.nab.mainservice.entity.Voucher;
import au.com.nab.mainservice.repository.VoucherRepository;
import au.com.nab.mainservice.service.impl.TokenServiceImpl;
import au.com.nab.mainservice.service.impl.VoucherServiceImpl;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class VoucherServiceImplTest {

    private VoucherService voucherService;
    private TokenService tokenService;
    private VoucherRepository voucherRepository;

    @Before
    public void init() {
        tokenService = Mockito.mock(TokenServiceImpl.class);
        voucherRepository = Mockito.mock(VoucherRepository.class);
        voucherService = new VoucherServiceImpl(tokenService, voucherRepository);
    }

    @Test
    public void getVouchers() {
        GetVoucherRequest getVoucherRequest = new GetVoucherRequest();
        getVoucherRequest.setEncryptPassword("123");
        getVoucherRequest.setSalt("123");
        getVoucherRequest.setToken("123");
        Token token = new Token();
        token.setPhoneNumber("123");
        token.setEncryptedToken("123");
        Optional<Token> optionalToken = Optional.of(token);
        when(tokenService.find(any(), any(), any())).thenReturn(optionalToken);
        List<Voucher> vouchers = new ArrayList<>();
        Voucher voucher = new Voucher();
        voucher.setPhoneNumber("123");
        voucher.setExpirationDate(new Date());
        voucher.setVoucher("abc");
        vouchers.add(voucher);
        when(voucherRepository.findAllByPhoneNumber(any())).thenReturn(vouchers);
        List<GetVoucherResponse> voucherResponses = voucherService.getVouchers(getVoucherRequest);
        assertEquals(1, voucherResponses.size());
        GetVoucherResponse getVoucherResponse = voucherResponses.get(0);
        assertEquals(voucher.getVoucher(), getVoucherResponse.getVoucherCode());
    }
}
