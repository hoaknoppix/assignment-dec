package au.com.nab.mainservice.client.dto;

public class SmsRequest {
  private String phoneNumber;
  private String message;

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  @Override
  public String toString() {
    return "SmsRequest{" +
        "phoneNumber='" + phoneNumber + '\'' +
        ", message='" + message + '\'' +
        '}';
  }
}
