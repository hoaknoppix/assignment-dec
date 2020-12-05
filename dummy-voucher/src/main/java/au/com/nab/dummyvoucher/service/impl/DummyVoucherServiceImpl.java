package au.com.nab.dummyvoucher.service.impl;

import au.com.nab.dummyvoucher.config.properties.ApplicationProperties;
import au.com.nab.dummyvoucher.dto.VoucherRequest;
import au.com.nab.dummyvoucher.dto.VoucherResponse;
import au.com.nab.dummyvoucher.service.DummyVoucherService;
import java.util.Calendar;
import java.util.Random;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class DummyVoucherServiceImpl implements DummyVoucherService {
  private ApplicationProperties applicationProperties;
  private Random random = new Random();

  public DummyVoucherServiceImpl(ApplicationProperties applicationProperties) {
    this.applicationProperties = applicationProperties;
  }
  /**
   * As this is a dummy 3rd party service, I made it simple without any spring security for authentication.
   * @param voucherRequest the input request.
   * @return voucherResponse which contains the sample token to create a voucher.
   * @throws InterruptedException when thread.sleep has any issues.
   */
  @Override
  public VoucherResponse createVoucher(VoucherRequest voucherRequest) throws InterruptedException {
    int sleepTime = random.nextInt(applicationProperties.getSleepTime()) * 1000;
    Thread.sleep(sleepTime);
    VoucherResponse voucherResponse = new VoucherResponse();
    voucherResponse.setCode(UUID.randomUUID().toString());
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.DATE, applicationProperties.getExpirationTime());
    voucherResponse.setExpiration(calendar.getTime());
    return voucherResponse;
  }
}
