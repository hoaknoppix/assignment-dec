package au.com.nab.mainservice.dto;

public class VoucherRequest {
  private String phoneNumber;
  private String token;

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  @Override
  public String toString() {
    return "VoucherRequest{" +
        "customerId='" + phoneNumber + '\'' +
        ", token='" + token + '\'' +
        '}';
  }
}
