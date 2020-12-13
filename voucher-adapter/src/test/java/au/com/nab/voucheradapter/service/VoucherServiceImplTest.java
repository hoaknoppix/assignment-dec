package au.com.nab.voucheradapter.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import au.com.nab.voucheradapter.client.MainServiceClient;
import au.com.nab.voucheradapter.client.SmsClient;
import au.com.nab.voucheradapter.client.VoucherClient;
import au.com.nab.voucheradapter.client.dto.VoucherRequest;
import au.com.nab.voucheradapter.client.dto.VoucherResponse;
import au.com.nab.voucheradapter.service.impl.VoucherServiceImpl;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class VoucherServiceImplTest {

    private VoucherService voucherService;
    private VoucherClient voucherClient;
    private SmsClient smsClient;
    private MainServiceClient mainServiceClient;

    @Before
    public void init() {
        voucherClient = Mockito.mock(VoucherClient.class);
        smsClient = Mockito.mock(SmsClient.class);
        mainServiceClient = Mockito.mock(MainServiceClient.class);
        voucherService = new VoucherServiceImpl(voucherClient, smsClient, mainServiceClient);
    }

    @Test
    public void createVoucher() {
        VoucherRequest voucherRequest = new VoucherRequest();
        voucherRequest.setPhoneNumber("123");
        voucherRequest.setVoucherServiceToken("456");
        VoucherResponse externalVoucherResponse = new VoucherResponse();
        externalVoucherResponse.setCode("789");
        externalVoucherResponse.setExpiration(new Date());
        when(voucherClient.createVoucher()).thenReturn(externalVoucherResponse);
        VoucherResponse voucherResponse = voucherService.createVoucher(voucherRequest);
        assertNotNull(voucherResponse.getCode());
        verify(mainServiceClient).saveVoucher(any());
    }
}
