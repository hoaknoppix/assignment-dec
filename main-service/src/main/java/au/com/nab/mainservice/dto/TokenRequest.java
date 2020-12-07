package au.com.nab.mainservice.dto;

import com.sun.istack.NotNull;

public class TokenRequest {
  @NotNull
  private String encryptPassword;
  @NotNull
  private String phoneNumber;

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getEncryptPassword() {
    return encryptPassword;
  }

  public void setEncryptPassword(String encryptPassword) {
    this.encryptPassword = encryptPassword;
  }

  @Override
  public String toString() {
    return "TokenRequest{" +
        "encryptPassword='" + encryptPassword + '\'' +
        ", phoneNumber='" + phoneNumber + '\'' +
        '}';
  }
}
