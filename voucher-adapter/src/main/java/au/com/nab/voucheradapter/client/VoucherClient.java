package au.com.nab.voucheradapter.client;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import au.com.nab.voucheradapter.client.dto.VoucherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "voucherClient", url = "http://localhost:8081/v1")
public interface VoucherClient {
    @PostMapping(value = "/voucher", produces = {APPLICATION_JSON_VALUE}, consumes = {APPLICATION_JSON_VALUE})
    VoucherResponse createVoucher();
}
