package au.com.nab.mainservice.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import au.com.nab.mainservice.dto.TokenRequest;
import au.com.nab.mainservice.dto.TokenResponse;
import au.com.nab.mainservice.service.TokenService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1")
public class UserController {

  private TokenService tokenService;

  public UserController(TokenService tokenService) {
    this.tokenService = tokenService;
  }

  @PostMapping(value = "/token", produces = {APPLICATION_JSON_VALUE}, consumes = {APPLICATION_JSON_VALUE})
  @ResponseStatus(HttpStatus.CREATED)
  public TokenResponse create(TokenRequest request) {
    return tokenService.create(request);
  }
}
