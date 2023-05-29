package com.knu.cloudapi.infrastructure.persistence.mapper;

import com.knu.cloudapi.domain.UserRole;
import com.knu.cloudapi.infrastructure.persistence.entity.UserRoleEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserRoleMapper {
    UserRoleEntity toEntity(UserRole userRole);
    UserRole fromEntity(UserRoleEntity userRoleEntity);
}
