package com.knu.cloudapi.infrastructure.persistence.mapper;

import com.knu.cloudapi.domain.User;
import com.knu.cloudapi.infrastructure.persistence.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserEntity toEntity(User user);
    User fromEntity(UserEntity entity);
}
