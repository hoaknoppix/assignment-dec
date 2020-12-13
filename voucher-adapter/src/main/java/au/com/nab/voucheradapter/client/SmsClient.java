package au.com.nab.voucheradapter.client;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import au.com.nab.voucheradapter.client.dto.SmsRequest;
import au.com.nab.voucheradapter.client.dto.SmsResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient (name = "smsClient", url = "http://localhost:8082/v1")
public interface SmsClient {
    @PostMapping(value = "/sms", produces = {APPLICATION_JSON_VALUE}, consumes = {APPLICATION_JSON_VALUE})
    SmsResponse sendSms(@RequestBody SmsRequest smsRequest);
}
