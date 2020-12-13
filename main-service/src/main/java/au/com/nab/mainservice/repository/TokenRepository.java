package au.com.nab.mainservice.repository;

import au.com.nab.mainservice.entity.Token;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {
    public Optional<Token> getTokenByEncryptedToken(String encryptedToken);
}
