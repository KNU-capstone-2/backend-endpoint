package com.knu.cloudapi.application.port.out;

import com.knu.cloudapi.infrastructure.persistence.entity.InstanceEntity;


public interface InstancePersistencePort {
    InstanceEntity getInstanceEntityById(Long id);
    InstanceEntity getInstanceEntityByName(String name);
    InstanceEntity save(InstanceEntity instance);
    void delete(Long id);
}
