package com.knu.cloudapi.infrastructure.adapter.out;

import com.knu.cloudapi.application.port.out.UserPersistencePort;
import com.knu.cloudapi.domain.User;
import com.knu.cloudapi.infrastructure.persistence.entity.UserEntity;
import com.knu.cloudapi.infrastructure.persistence.mapper.UserMapper;
import com.knu.cloudapi.infrastructure.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserPersistencePort {

  private final UserRepository userRepository;

  private final UserMapper userMapper;

  @Override
  public User findByUsername(String username) {
    return userMapper.fromEntity(userRepository.findByUsername(username)
        .orElseThrow(NullPointerException::new));
  }

  @Override
  public void save(User user) {
    userRepository.save(userMapper.toEntity(user));
  }
}
