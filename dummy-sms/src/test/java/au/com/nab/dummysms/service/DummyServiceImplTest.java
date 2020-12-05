package au.com.nab.dummysms.service;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import au.com.nab.dummysms.dto.SmsRequest;
import au.com.nab.dummysms.dto.SmsResponse;
import au.com.nab.dummysms.service.impl.DummySmsServiceImpl;
import org.junit.Before;
import org.junit.Test;

public class DummyServiceImplTest {

  private DummySmsService dummySmsService;

  @Before
  public void init() {
    dummySmsService = new DummySmsServiceImpl();
  }

  @Test
  public void sendSms() {
    SmsRequest smsRequest = new SmsRequest();
    smsRequest.setMessage("Hello");
    SmsResponse smsResponse = dummySmsService.sendSms(smsRequest);
    assertNotNull(smsResponse);
    assertEquals("Sent", smsResponse.getStatus());
  }
}
