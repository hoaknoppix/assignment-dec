package au.com.nab.mainservice.dto;

public class TokenResponse {
  private String token;

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  @Override
  public String toString() {
    return "TokenResponse{" +
        ", token='" + token + '\'' +
        '}';
  }
}
