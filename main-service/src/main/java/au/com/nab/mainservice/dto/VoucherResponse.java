package au.com.nab.mainservice.dto;

import java.util.Date;

public class VoucherResponse {
  private String status;
  private String voucherCode;
  private Date expirationDate;

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getVoucherCode() {
    return voucherCode;
  }

  public void setVoucherCode(String voucherCode) {
    this.voucherCode = voucherCode;
  }

  public Date getExpirationDate() {
    return expirationDate;
  }

  public void setExpirationDate(Date expirationDate) {
    this.expirationDate = expirationDate;
  }

  @Override
  public String toString() {
    return "VoucherResponse{" +
        "status='" + status + '\'' +
        ", voucherCode='" + voucherCode + '\'' +
        ", expirationDate=" + expirationDate +
        '}';
  }
}
