package au.com.nab.mainservice.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Token {
  @Id
  private Long id;
  private String phoneNumber;
  private String encryptedToken;
  private Date expirationDate;

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getEncryptedToken() {
    return encryptedToken;
  }

  public void setEncryptedToken(String encryptedToken) {
    this.encryptedToken = encryptedToken;
  }

  public Date getExpirationDate() {
    return expirationDate;
  }

  public void setExpirationDate(Date expirationDate) {
    this.expirationDate = expirationDate;
  }

  @Override
  public String toString() {
    return "Token{" +
        "phoneNumber='" + phoneNumber + '\'' +
        ", encryptedToken='" + encryptedToken + '\'' +
        ", expirationDate='" + expirationDate + '\'' +
        '}';
  }
}
