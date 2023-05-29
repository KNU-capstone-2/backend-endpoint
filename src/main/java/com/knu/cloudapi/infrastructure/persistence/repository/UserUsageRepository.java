package com.knu.cloudapi.infrastructure.persistence.repository;

import com.knu.cloudapi.infrastructure.persistence.entity.UserUsageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserUsageRepository extends JpaRepository<UserUsageEntity, Long> {
}
