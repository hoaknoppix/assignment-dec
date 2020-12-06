package au.com.nab.mainservice.service.impl;

import au.com.nab.mainservice.dto.TokenRequest;
import au.com.nab.mainservice.dto.TokenResponse;
import au.com.nab.mainservice.service.TokenService;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {

  @Override
  public TokenResponse create(TokenRequest request) {
    return null;
  }
}
