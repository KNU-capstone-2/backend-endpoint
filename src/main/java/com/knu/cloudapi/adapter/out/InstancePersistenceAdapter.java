package com.knu.cloudapi.adapter.out;

import com.knu.cloudapi.application.port.out.InstancePersistencePort;
import com.knu.cloudapi.domain.Instance;
import com.knu.cloudapi.infrastructure.persistence.mapper.InstanceMapper;
import com.knu.cloudapi.infrastructure.persistence.repository.InstanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class InstancePersistenceAdapter implements InstancePersistencePort {
    private final InstanceRepository instanceRepository;
    private final InstanceMapper instanceMapper;

    @Override
    public Instance getInstanceById(Long id) {
        return instanceMapper.fromEntity(instanceRepository.findById(id).orElseThrow(NullPointerException::new));
    }
}
