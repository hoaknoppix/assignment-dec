package au.com.nab.mainservice.client.dto;

public class SmsRequest {
  private String message;

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public String toString() {
    return "SmsRequest{" +
        "message='" + message + '\'' +
        '}';
  }
}