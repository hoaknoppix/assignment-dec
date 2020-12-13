package au.com.nab.voucheradapter.client.dto;

public class SmsResponse {
  private String status;

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "SmsResponse{" +
        "status='" + status + '\'' +
        '}';
  }
}
