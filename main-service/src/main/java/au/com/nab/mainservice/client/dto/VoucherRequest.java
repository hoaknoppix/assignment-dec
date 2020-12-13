package au.com.nab.mainservice.client.dto;

public class VoucherRequest {
  private String phoneNumber;
  private String voucherServiceToken;

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getVoucherServiceToken() {
    return voucherServiceToken;
  }

  public void setVoucherServiceToken(String voucherServiceToken) {
    this.voucherServiceToken = voucherServiceToken;
  }

  @Override
  public String toString() {
    return "VoucherRequest{" +
        "customerId='" + phoneNumber + '\'' +
        ", voucherServiceToken='" + voucherServiceToken + '\'' +
        '}';
  }
}
