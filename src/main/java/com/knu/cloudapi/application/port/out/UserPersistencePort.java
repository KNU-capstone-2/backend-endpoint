package com.knu.cloudapi.application.port.out;

import com.knu.cloudapi.domain.User;
import com.knu.cloudapi.infrastructure.persistence.entity.UserEntity;

public interface UserPersistencePort {
  User findByUsername(String username);
  void save(User user);
  void save(UserEntity userEntity);
  UserEntity findById(Long id);
}
