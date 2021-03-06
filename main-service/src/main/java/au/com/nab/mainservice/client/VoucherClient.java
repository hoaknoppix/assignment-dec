package au.com.nab.mainservice.client;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import au.com.nab.mainservice.client.dto.VoucherRequest;
import au.com.nab.mainservice.client.dto.VoucherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "voucherClient", url = "http://localhost:8083/v1")
public interface VoucherClient {
    @PostMapping(value = "/voucher", produces = {APPLICATION_JSON_VALUE}, consumes = {APPLICATION_JSON_VALUE})
    public VoucherResponse createVoucher(@RequestBody VoucherRequest voucherRequest);
}
