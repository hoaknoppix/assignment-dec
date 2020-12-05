package au.com.nab.dummysms.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import au.com.nab.dummysms.dto.SmsRequest;
import au.com.nab.dummysms.dto.SmsResponse;
import au.com.nab.dummysms.service.DummySmsService;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1")
public class DummySmsController {
  private DummySmsService dummySmsService;

  public DummySmsController(DummySmsService dummySmsService) {
    this.dummySmsService = dummySmsService;
  }

  @PostMapping(value = "/sms", produces = {APPLICATION_JSON_VALUE}, consumes = {APPLICATION_JSON_VALUE})
  @ResponseStatus(HttpStatus.CREATED)
  public SmsResponse sendSms(@RequestBody @Valid SmsRequest smsRequest) {
    return dummySmsService.sendSms(smsRequest);
  }
}
