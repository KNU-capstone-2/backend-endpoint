package com.knu.cloudapi.adapter.out.persistence;

import com.knu.cloudapi.application.port.out.UserUsagePersistencePort;
import com.knu.cloudapi.infrastructure.persistence.entity.UserUsageEntity;
import com.knu.cloudapi.infrastructure.persistence.repository.UserUsageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserUsagePersistenceAdapter implements UserUsagePersistencePort {
    private final UserUsageRepository userUsageRepository;

    @Override
    public UserUsageEntity save(UserUsageEntity userUsageEntity) {
        return userUsageRepository.save(userUsageEntity);
    }

    @Override
    public UserUsageEntity getUserUsageById(Long id) {
        return userUsageRepository.findById(id).orElse(null);
    }
}
