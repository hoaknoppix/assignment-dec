package au.com.nab.mainservice.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Voucher {
  @GeneratedValue
  @Id
  private Long id;
  private String phoneNumber;
  private String code;
  private Date expirationDate;

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String voucher) {
    this.code = voucher;
  }

  public Date getExpirationDate() {
    return expirationDate;
  }

  public void setExpirationDate(Date expirationDate) {
    this.expirationDate = expirationDate;
  }

  @Override
  public String toString() {
    return "Voucher{" +
        "id=" + id +
        ", phoneNumber='" + phoneNumber + '\'' +
        ", code='" + code + '\'' +
        ", expirationDate=" + expirationDate +
        '}';
  }
}
