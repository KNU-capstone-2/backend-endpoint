package com.knu.cloudapi.infrastructure.persistence.mapper;

import com.knu.cloudapi.application.dto.response.InstanceResponse;
import com.knu.cloudapi.domain.Instance;
import com.knu.cloudapi.infrastructure.persistence.entity.InstanceEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InstanceMapper {
    InstanceEntity toEntity(Instance instance);

    Instance fromEntity(InstanceEntity instanceEntity);

    InstanceResponse toResponseDto(Instance instance);
    Instance fromResponseDto(InstanceResponse instanceResponse);


}
