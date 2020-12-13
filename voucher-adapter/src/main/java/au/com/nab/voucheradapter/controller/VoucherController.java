package au.com.nab.voucheradapter.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import au.com.nab.voucheradapter.client.dto.VoucherRequest;
import au.com.nab.voucheradapter.service.VoucherService;
import au.com.nab.voucheradapter.client.dto.VoucherResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
  public VoucherResponse createVoucher(@RequestBody VoucherRequest voucherRequest) {
    return voucherService.createVoucher(voucherRequest);
  }
}
