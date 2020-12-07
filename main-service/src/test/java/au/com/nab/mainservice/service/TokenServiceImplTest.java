package au.com.nab.mainservice.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;

import au.com.nab.mainservice.client.SmsClient;
import au.com.nab.mainservice.client.dto.SmsRequest;
import au.com.nab.mainservice.dto.TokenRequest;
import au.com.nab.mainservice.dto.TokenResponse;
import au.com.nab.mainservice.entity.Token;
import au.com.nab.mainservice.repository.TokenRepository;
import au.com.nab.mainservice.service.impl.TokenServiceImpl;
import java.util.Base64;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.security.crypto.encrypt.BytesEncryptor;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.keygen.KeyGenerators;

public class TokenServiceImplTest {

    private TokenService tokenService;
    private TokenRepository tokenRepository;
    private SmsClient smsClient;

    @Before
    public void init() {
        tokenRepository = Mockito.mock(TokenRepository.class);
        smsClient = Mockito.mock(SmsClient.class);
        tokenService = new TokenServiceImpl(tokenRepository, smsClient);
    }

    @Test
    public void createToken() {
        TokenRequest tokenRequest = new TokenRequest();
        tokenRequest.setPhoneNumber("123");
        tokenRequest.setEncryptPassword("password");
        TokenResponse tokenResponse = tokenService.create(tokenRequest);
        assertNotNull(tokenResponse);
        String token = tokenResponse.getToken();
        assertNotNull(token);
        ArgumentCaptor<Token> tokenArgumentCaptor = ArgumentCaptor.forClass(Token.class);
        verify(tokenRepository).saveAndFlush(tokenArgumentCaptor.capture());
        Token savedToken = tokenArgumentCaptor.getValue();
        assertNotNull(savedToken);
        assertNotNull(savedToken.getExpirationDate());
        String encryptedToken = savedToken.getEncryptedToken();
        assertNotNull(encryptedToken);
        assertNotNull(savedToken.getPhoneNumber());
        ArgumentCaptor<SmsRequest> smsArgumentCaptor = ArgumentCaptor.forClass(SmsRequest.class);
        verify(smsClient).sendSms(smsArgumentCaptor.capture());
        SmsRequest smsRequest = smsArgumentCaptor.getValue();
        assertNotNull(smsRequest);
        String salt = smsRequest.getMessage().split(":")[1].trim();
        BytesEncryptor bytesEncryptor = Encryptors.standard(tokenRequest.getEncryptPassword(), salt);
        byte[] decryptedBytes = bytesEncryptor.decrypt(Base64.getDecoder().decode(encryptedToken));
        String decryptedToken = new String(decryptedBytes);
        assertEquals(token, decryptedToken);
    }
}
