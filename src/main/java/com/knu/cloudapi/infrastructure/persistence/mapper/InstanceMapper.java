package com.knu.cloudapi.infrastructure.persistence.mapper;

import com.knu.cloudapi.domain.Instance;
import com.knu.cloudapi.infrastructure.persistence.entity.InstanceEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InstanceMapper {
    InstanceEntity toEntity(Instance instance);

    Instance fromEntity(InstanceEntity instanceEntity);
}
