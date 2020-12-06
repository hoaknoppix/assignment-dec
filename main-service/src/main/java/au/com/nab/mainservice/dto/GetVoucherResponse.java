package au.com.nab.mainservice.dto;

public class GetVoucherResponse {
  private String voucherCode;

  public String getVoucherCode() {
    return voucherCode;
  }

  public void setVoucherCode(String voucherCode) {
    this.voucherCode = voucherCode;
  }

  @Override
  public String toString() {
    return "GetVoucherResponse{" +
        "voucherCode='" + voucherCode + '\'' +
        '}';
  }
}
