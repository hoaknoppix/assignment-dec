package au.com.nab.mainservice.dto;

public class TokenResponse {
  private String status;

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "TokenResponse{" +
        "status='" + status + '\'' +
        '}';
  }
}
