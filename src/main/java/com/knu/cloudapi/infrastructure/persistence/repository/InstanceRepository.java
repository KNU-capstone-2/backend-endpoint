package com.knu.cloudapi.infrastructure.persistence.repository;

import com.knu.cloudapi.infrastructure.persistence.entity.InstanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstanceRepository extends JpaRepository<InstanceEntity, Long> {
    InstanceEntity findByInstanceName(String name);
}
