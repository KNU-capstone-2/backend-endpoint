package com.knu.cloudapi.application.port.out;

import com.knu.cloudapi.domain.User;
import com.knu.cloudapi.infrastructure.persistence.entity.UserEntity;

import java.util.Optional;

public interface UserPersistencePort {
  User findByUsername(String username);
  User findByEmail(String email);
  void save(User user);
  void save(UserEntity userEntity);
  Optional<UserEntity> findById(Long id);
}
