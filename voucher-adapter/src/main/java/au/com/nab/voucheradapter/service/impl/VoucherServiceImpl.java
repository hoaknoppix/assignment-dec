package au.com.nab.voucheradapter.service.impl;

import au.com.nab.voucheradapter.client.SmsClient;
import au.com.nab.voucheradapter.client.VoucherClient;
import au.com.nab.voucheradapter.client.dto.SmsRequest;
import au.com.nab.voucheradapter.client.dto.VoucherRequest;
import au.com.nab.voucheradapter.client.dto.VoucherResponse;
import au.com.nab.voucheradapter.service.VoucherService;
import org.springframework.stereotype.Service;

@Service
public class VoucherServiceImpl implements VoucherService {
  private VoucherClient voucherClient;
  private SmsClient smsClient;

  public VoucherServiceImpl(VoucherClient voucherClient, SmsClient smsClient) {
    this.voucherClient = voucherClient;
    this.smsClient = smsClient;
  }

  @Override
  public VoucherResponse createVoucher(VoucherRequest voucherRequest) {
      VoucherResponse externalVoucherResponse = voucherClient.createVoucher();
      SmsRequest smsRequest = new SmsRequest();
      smsRequest.setPhoneNumber(voucherRequest.getPhoneNumber());
      smsRequest.setMessage("The voucher is created: " + externalVoucherResponse.getCode());
      smsClient.sendSms(smsRequest);
      return externalVoucherResponse;
  }
}
