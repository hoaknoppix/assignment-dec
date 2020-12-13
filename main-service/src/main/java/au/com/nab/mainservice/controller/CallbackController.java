package au.com.nab.mainservice.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import au.com.nab.mainservice.dto.VoucherCallbackRequest;
import au.com.nab.mainservice.dto.VoucherRequest;
import au.com.nab.mainservice.dto.VoucherResponse;
import au.com.nab.mainservice.service.VoucherService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1")
public class CallbackController {

  private VoucherService voucherService;

  public CallbackController(VoucherService voucherService) {
    this.voucherService = voucherService;
  }

  @PostMapping(value = "/callback/voucher", produces = {APPLICATION_JSON_VALUE}, consumes = {APPLICATION_JSON_VALUE})
  @ResponseStatus(HttpStatus.CREATED)
  public void saveVoucher(@RequestBody VoucherCallbackRequest voucherCallbackRequest) {
    voucherService.saveVoucher(voucherCallbackRequest);
  }
}
