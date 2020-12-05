package au.com.nab.dummysms.service;

import au.com.nab.dummysms.dto.SmsRequest;
import au.com.nab.dummysms.dto.SmsResponse;

public interface DummySmsService {
  SmsResponse sendSms(SmsRequest smsRequest);
}
