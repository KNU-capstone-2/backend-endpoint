package com.knu.cloudapi.application.port.in;

import com.knu.cloudapi.domain.UserUsage;

public interface UserUsageUseCase {
    UserUsage read();

    UserUsage update(UserUsage userUsage);

    void delete(Long id);
}
