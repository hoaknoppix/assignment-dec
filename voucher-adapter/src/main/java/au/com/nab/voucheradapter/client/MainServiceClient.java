package au.com.nab.voucheradapter.client;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import au.com.nab.voucheradapter.client.dto.VoucherCallbackRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "mainServiceClient", url = "http://localhost:8080/v1")
public interface MainServiceClient {
  @PostMapping(value = "/callback/voucher", produces = {APPLICATION_JSON_VALUE}, consumes = {APPLICATION_JSON_VALUE})
  void saveVoucher(@RequestBody VoucherCallbackRequest voucherCallbackRequest);
}
