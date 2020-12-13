package au.com.nab.voucheradapter.client.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

public class VoucherCallbackRequest {
  private String phoneNumber;
  private String voucherServiceToken;
  private String code;
  @JsonFormat(pattern="yyyy-MM-dd")
  private Date expiration;

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Date getExpiration() {
    return expiration;
  }

  public void setExpiration(Date expiration) {
    this.expiration = expiration;
  }


  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getVoucherServiceToken() {
    return voucherServiceToken;
  }

  public void setVoucherServiceToken(String voucherServiceToken) {
    this.voucherServiceToken = voucherServiceToken;
  }

  @Override
  public String toString() {
    return "VoucherCallbackRequest{" +
        "phoneNumber='" + phoneNumber + '\'' +
        ", voucherServiceToken='" + voucherServiceToken + '\'' +
        ", code='" + code + '\'' +
        ", expiration=" + expiration +
        '}';
  }
}
