package com.knu.cloudapi.infrastructure.persistence.mapper;

import com.knu.cloudapi.domain.UserUsage;
import com.knu.cloudapi.infrastructure.persistence.entity.UserUsageEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserUsageMapper{
    UserUsageEntity toEntity(UserUsage userUsage);
    UserUsage fromEntity(UserUsageEntity userUsageEntity);
}
