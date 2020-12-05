package au.com.nab.dummyvoucher.dto;

public class VoucherRequest {
  private String token;

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  @Override
  public String toString() {
    return "VoucherRequest{" +
        "token='" + token + '\'' +
        '}';
  }
}
