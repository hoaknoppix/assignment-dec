package au.com.nab.mainservice.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import au.com.nab.mainservice.dto.GetVoucherRequest;
import au.com.nab.mainservice.dto.GetVoucherResponse;
import au.com.nab.mainservice.dto.VoucherRequest;
import au.com.nab.mainservice.dto.VoucherResponse;
import au.com.nab.mainservice.service.VoucherService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1")
public class VoucherController {

  private VoucherService voucherService;

  public VoucherController(VoucherService voucherService) {
    this.voucherService = voucherService;
  }

  @PostMapping(value = "/voucher", produces = {APPLICATION_JSON_VALUE}, consumes = {APPLICATION_JSON_VALUE})
  @ResponseStatus(HttpStatus.CREATED)
  public VoucherResponse createVoucher(VoucherRequest voucherRequest) {
    return voucherService.createVoucher(voucherRequest);
  }

  @GetMapping(value = "/vouchers", produces = {APPLICATION_JSON_VALUE}, consumes = {APPLICATION_JSON_VALUE})
  @ResponseStatus(HttpStatus.OK)
  public List<GetVoucherResponse> getVouchers(GetVoucherRequest getVoucherRequest) {
    return voucherService.getVouchers(getVoucherRequest);
  }
}
