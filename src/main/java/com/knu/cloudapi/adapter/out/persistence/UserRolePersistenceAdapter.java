package com.knu.cloudapi.adapter.out.persistence;

import com.knu.cloudapi.application.port.out.UserRolePersistencePort;
import com.knu.cloudapi.common.Role;
import com.knu.cloudapi.infrastructure.persistence.entity.UserRoleEntity;
import com.knu.cloudapi.infrastructure.persistence.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserRolePersistenceAdapter implements UserRolePersistencePort {
    private final UserRoleRepository userRoleRepository;

    @Override
    public UserRoleEntity getUserRoleByRole(Role role) {
        return userRoleRepository.findByRole(role);
    }
}
