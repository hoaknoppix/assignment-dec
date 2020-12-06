package au.com.nab.mainservice.service;

import au.com.nab.mainservice.dto.TokenRequest;
import au.com.nab.mainservice.dto.TokenResponse;

public interface TokenService {

  TokenResponse create(TokenRequest request);
}
