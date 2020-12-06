package au.com.nab.mainservice.dto;

public class TokenRequest {
  private String phoneNumber;

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  @Override
  public String toString() {
    return "TokenRequest{" +
        "phoneNumber='" + phoneNumber + '\'' +
        '}';
  }
}
