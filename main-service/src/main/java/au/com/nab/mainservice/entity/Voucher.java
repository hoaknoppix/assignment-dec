package au.com.nab.mainservice.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Voucher {
  @Id
  private Long id;
  private String phoneNumber;
  private String voucher;
  private Date expirationDate;

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getVoucher() {
    return voucher;
  }

  public void setVoucher(String voucher) {
    this.voucher = voucher;
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
        ", voucher='" + voucher + '\'' +
        ", expirationDate=" + expirationDate +
        '}';
  }
}
