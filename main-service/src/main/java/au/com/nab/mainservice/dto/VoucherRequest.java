package au.com.nab.mainservice.dto;

public class VoucherRequest {
  private String customerId;
  private String token;

  public String getCustomerId() {
    return customerId;
  }

  public void setCustomerId(String customerId) {
    this.customerId = customerId;
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
        "customerId='" + customerId + '\'' +
        ", token='" + token + '\'' +
        '}';
  }
}
