package com.example.demo.repository;

import com.example.demo.auth.redis.domain.Token;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface RedisTokenRepository extends CrudRepository<Token, Long> {

  Optional<Token> findByRefreshToken(final String refreshToken);
  Optional<Token> findById(final String id);
}
