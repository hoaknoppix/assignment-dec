package au.com.nab.voucheradapter.service.impl;

import au.com.nab.voucheradapter.client.MainServiceClient;
import au.com.nab.voucheradapter.client.SmsClient;
import au.com.nab.voucheradapter.client.VoucherClient;
import au.com.nab.voucheradapter.client.dto.SmsRequest;
import au.com.nab.voucheradapter.client.dto.VoucherCallbackRequest;
import au.com.nab.voucheradapter.client.dto.VoucherRequest;
import au.com.nab.voucheradapter.client.dto.VoucherResponse;
import au.com.nab.voucheradapter.service.VoucherService;
import org.springframework.stereotype.Service;

@Service
public class VoucherServiceImpl implements VoucherService {

  private VoucherClient voucherClient;
  private SmsClient smsClient;
  private MainServiceClient mainServiceClient;

  public VoucherServiceImpl(VoucherClient voucherClient, SmsClient smsClient,
      MainServiceClient mainServiceClient) {
    this.voucherClient = voucherClient;
    this.smsClient = smsClient;
    this.mainServiceClient = mainServiceClient;
  }

  @Override
  public VoucherResponse createVoucher(VoucherRequest voucherRequest) {
    VoucherResponse externalVoucherResponse = voucherClient.createVoucher();
    SmsRequest smsRequest = new SmsRequest();
    smsRequest.setPhoneNumber(voucherRequest.getPhoneNumber());
    smsRequest.setMessage("The voucher is created: " + externalVoucherResponse.getCode());
    smsClient.sendSms(smsRequest);
    callBackToMainService(voucherRequest, externalVoucherResponse);
    return externalVoucherResponse;
  }

  private void callBackToMainService(VoucherRequest voucherRequest,
      VoucherResponse externalVoucherResponse) {
    VoucherCallbackRequest voucherCallbackRequest = new VoucherCallbackRequest();
    voucherCallbackRequest.setVoucherServiceToken(voucherRequest.getVoucherServiceToken());
    voucherCallbackRequest.setCode(externalVoucherResponse.getCode());
    voucherCallbackRequest.setExpiration(externalVoucherResponse.getExpiration());
    voucherCallbackRequest.setPhoneNumber(voucherRequest.getPhoneNumber());
    mainServiceClient.saveVoucher(voucherCallbackRequest);
  }
}
