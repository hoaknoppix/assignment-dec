package au.com.nab.mainservice.dto;

public class GetVoucherRequest {
  private String token;
  private String salt;
  private String encryptPassword;

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public String getSalt() {
    return salt;
  }

  public void setSalt(String salt) {
    this.salt = salt;
  }

  public String getEncryptPassword() {
    return encryptPassword;
  }

  public void setEncryptPassword(String encryptPassword) {
    this.encryptPassword = encryptPassword;
  }

  @Override
  public String toString() {
    return "GetVoucherRequest{" +
        "token='" + token + '\'' +
        ", salt='" + salt + '\'' +
        ", encryptPassword='" + encryptPassword + '\'' +
        '}';
  }
}
