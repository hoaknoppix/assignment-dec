package au.com.nab.mainservice.service;

import au.com.nab.mainservice.dto.TokenRequest;
import au.com.nab.mainservice.dto.TokenResponse;
import au.com.nab.mainservice.entity.Token;
import java.util.Optional;

public interface TokenService {

  TokenResponse create(TokenRequest request);

  Optional<Token> find(String encryptedPassword, String salt, String tokenString);
}
