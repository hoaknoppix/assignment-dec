package au.com.nab.mainservice.dto;

public class GetVoucherRequest {
  private String token;

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  @Override
  public String toString() {
    return "GetVoucherRequest{" +
        "token='" + token + '\'' +
        '}';
  }
}
