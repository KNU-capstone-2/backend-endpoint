package com.knu.cloudapi.adapter.out.persistence;

import com.knu.cloudapi.application.port.out.UserPersistencePort;
import com.knu.cloudapi.application.port.out.UserRolePersistencePort;
import com.knu.cloudapi.application.port.out.UserUsagePersistencePort;
import com.knu.cloudapi.domain.User;
import com.knu.cloudapi.infrastructure.persistence.entity.UserEntity;
import com.knu.cloudapi.infrastructure.persistence.entity.UserUsageEntity;
import com.knu.cloudapi.infrastructure.persistence.mapper.UserMapper;
import com.knu.cloudapi.infrastructure.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserPersistencePort {

  private final UserRepository userRepository;
  private final UserMapper userMapper;
  private final UserRolePersistencePort userRolePersistencePort;
  private final UserUsagePersistencePort userUsagePersistencePort;


  @Override
  public User findByUsername(String username) {
    return userMapper.fromEntity(userRepository.findByUsername(username)
        .orElseThrow(NullPointerException::new));
  }

  @Override
  public void save(User user) {
    UserEntity userEntity = userMapper.toEntity(user);
    userEntity.setUserRoleEntity(userRolePersistencePort.getUserRoleByRole(user.getRole()));
    userEntity.setUserUsageEntity(userUsagePersistencePort.save(new UserUsageEntity(0, 0, 0, 0)));
    userRepository.save(userEntity);
  }

  @Override
  public void save(UserEntity userEntity) {
    userRepository.save(userEntity);
  }

  @Override
  public UserEntity findById(Long id) {
    return userRepository.findById(id).orElseThrow(NullPointerException::new);
  }
}
