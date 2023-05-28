package com.knu.cloudapi.adapter.out.persistence;

import com.knu.cloudapi.application.port.out.InstancePersistencePort;
import com.knu.cloudapi.infrastructure.persistence.entity.InstanceEntity;
import com.knu.cloudapi.infrastructure.persistence.repository.InstanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class InstancePersistenceAdapter implements InstancePersistencePort {
    private final InstanceRepository instanceRepository;

    @Override
    public InstanceEntity getInstanceEntityById(Long id) {
        return instanceRepository.findById(id).orElse(null);
    }

    @Override
    public InstanceEntity getInstanceEntityByName(String name) {
        return instanceRepository.findByInstanceName(name);
    }

    @Override
    public InstanceEntity save(InstanceEntity instance) {
        return instanceRepository.save(instance);
    }

    @Override
    public void delete(Long id) {
        instanceRepository.deleteById(id);
    }

}
