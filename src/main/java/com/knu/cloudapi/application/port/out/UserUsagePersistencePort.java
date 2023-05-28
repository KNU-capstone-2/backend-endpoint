package com.knu.cloudapi.application.port.out;

import com.knu.cloudapi.common.Role;
import com.knu.cloudapi.domain.UserUsage;
import com.knu.cloudapi.infrastructure.persistence.entity.UserUsageEntity;

public interface UserUsagePersistencePort {
    UserUsageEntity save(UserUsageEntity UserUsageEntity);
}
