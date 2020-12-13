package au.com.nab.voucheradapter.client.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

public class VoucherResponse {
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

  @Override
  public String toString() {
    return "VoucherResponse{" +
        "code='" + code + '\'' +
        ", expiration=" + expiration +
        '}';
  }
}
