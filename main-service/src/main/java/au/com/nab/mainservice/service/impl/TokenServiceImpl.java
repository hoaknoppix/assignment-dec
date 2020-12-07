package au.com.nab.mainservice.service.impl;

import au.com.nab.mainservice.client.SmsClient;
import au.com.nab.mainservice.client.dto.SmsRequest;
import au.com.nab.mainservice.dto.TokenRequest;
import au.com.nab.mainservice.dto.TokenResponse;
import au.com.nab.mainservice.entity.Token;
import au.com.nab.mainservice.repository.TokenRepository;
import au.com.nab.mainservice.service.TokenService;
import java.util.Base64;
import java.util.Calendar;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.crypto.encrypt.BytesEncryptor;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.keygen.KeyGenerators;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {

  private TokenRepository tokenRepository;
  private SmsClient smsClient;

  public TokenServiceImpl(TokenRepository tokenRepository, SmsClient smsClient) {
    this.tokenRepository = tokenRepository;
    this.smsClient = smsClient;
  }

  @Override
  public TokenResponse create(TokenRequest request) {
    Token token = new Token();
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.HOUR, 1);
    String salt = KeyGenerators.string().generateKey();
    sendSms(salt);
    String tokenString = UUID.randomUUID().toString();
    String encryptedToken = createEncryptedToken(request.getEncryptPassword(), salt, tokenString);
    token.setEncryptedToken(encryptedToken);
    token.setExpirationDate(calendar.getTime());
    token.setPhoneNumber(request.getPhoneNumber());
    tokenRepository.saveAndFlush(token);
    TokenResponse tokenResponse = new TokenResponse();
    tokenResponse.setToken(tokenString);
    return tokenResponse;
  }

  @Async
  public void sendSms(String salt) {
    SmsRequest smsRequest = new SmsRequest();
    smsRequest.setMessage("Your salt value is:" + salt);
    smsClient.sendSms(smsRequest);
  }

  @Override
  public Optional<Token> find(String encryptedPassword, String salt, String tokenString) {
    String encryptedToken = createEncryptedToken(encryptedPassword, salt, tokenString);
    return tokenRepository.getTokenByEncryptedToken(encryptedToken);
  }

  private String createEncryptedToken(String encryptedPassword, String salt, String tokenString) {
    BytesEncryptor bytesEncryptor = Encryptors.standard(encryptedPassword, salt);
    byte[] bytes = bytesEncryptor.encrypt(tokenString.getBytes());
    return Base64.getEncoder().encodeToString(bytes);
  }
}
