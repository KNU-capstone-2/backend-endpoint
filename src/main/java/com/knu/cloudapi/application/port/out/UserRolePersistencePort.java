package com.knu.cloudapi.application.port.out;

import com.knu.cloudapi.common.Role;
import com.knu.cloudapi.infrastructure.persistence.entity.UserRoleEntity;

public interface UserRolePersistencePort {
    UserRoleEntity getUserRoleByRole(Role role);
}
