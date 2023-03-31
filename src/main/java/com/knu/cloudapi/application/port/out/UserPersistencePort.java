package com.knu.cloudapi.application.port.out;

import com.knu.cloudapi.domain.User;

public interface UserPersistencePort {
  User findByUsername(String username);
  void save(User user);
}
