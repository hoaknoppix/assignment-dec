package au.com.nab.dummysms.service.impl;

import au.com.nab.dummysms.dto.SmsRequest;
import au.com.nab.dummysms.dto.SmsResponse;
import au.com.nab.dummysms.service.DummySmsService;
import org.springframework.stereotype.Service;

@Service
public class DummySmsServiceImpl implements DummySmsService {

  @Override
  public SmsResponse sendSms(SmsRequest smsRequest) {
      SmsResponse smsResponse = new SmsResponse();
      smsResponse.setStatus("Sent");
      return smsResponse;
  }
}
