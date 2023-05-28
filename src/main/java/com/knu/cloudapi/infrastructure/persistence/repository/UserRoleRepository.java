package com.knu.cloudapi.infrastructure.persistence.repository;

import com.knu.cloudapi.common.Role;
import com.knu.cloudapi.infrastructure.persistence.entity.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {
    UserRoleEntity findByRole(Role role);
}
