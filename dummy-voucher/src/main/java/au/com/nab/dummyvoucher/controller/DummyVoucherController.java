package au.com.nab.dummyvoucher.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import au.com.nab.dummyvoucher.dto.VoucherResponse;
import au.com.nab.dummyvoucher.service.DummyVoucherService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1")
public class DummyVoucherController {

  private DummyVoucherService dummyVoucherService;

  public DummyVoucherController(DummyVoucherService dummyVoucherService) {
    this.dummyVoucherService = dummyVoucherService;
  }

  @PostMapping(value = "/voucher", produces = {APPLICATION_JSON_VALUE}, consumes = {APPLICATION_JSON_VALUE})
  @ResponseStatus(HttpStatus.CREATED)
  public VoucherResponse createVoucher()
      throws InterruptedException {
    return dummyVoucherService.createVoucher();
  }

}
