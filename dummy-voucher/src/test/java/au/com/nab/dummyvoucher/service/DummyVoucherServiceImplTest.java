package au.com.nab.dummyvoucher.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import au.com.nab.dummyvoucher.config.properties.ApplicationProperties;
import au.com.nab.dummyvoucher.dto.VoucherResponse;
import au.com.nab.dummyvoucher.service.impl.DummyVoucherServiceImpl;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;

public class DummyVoucherServiceImplTest {

  private DummyVoucherService dummyVoucherService;

  @Before
  public void init() {
    ApplicationProperties applicationProperties = new ApplicationProperties();
    applicationProperties.setSleepTime(1);
    applicationProperties.setExpirationTime(1);
    dummyVoucherService = new DummyVoucherServiceImpl(applicationProperties);
  }

  @Test
  public void getVoucher() throws InterruptedException {
    VoucherResponse response = dummyVoucherService.createVoucher();
    assertNotNull(response);
    String code = response.getCode();
    Date expiration = response.getExpiration();
    assertNotNull(code);
    assertNotNull(expiration);
  }
}
