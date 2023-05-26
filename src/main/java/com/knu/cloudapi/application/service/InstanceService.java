package com.knu.cloudapi.application.service;

import com.knu.cloudapi.application.port.in.InstanceUseCase;
import com.knu.cloudapi.application.port.out.InstancePersistencePort;
import com.knu.cloudapi.application.port.out.InstanceRestTemplatePort;
import com.knu.cloudapi.domain.Instance;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class InstanceService implements InstanceUseCase {
    private final InstanceRestTemplatePort instanceRestTemplatePort;
    private final InstancePersistencePort instancePersistencePort;

    @Override
    public Instance getInstance(Long id) {
        Instance instance = instancePersistencePort.getInstanceById(id);
        return instanceRestTemplatePort.getInstance(instance.getInstanceName());
    }

    @Override
    public ArrayList<Instance> getAllInstance() {
        return instanceRestTemplatePort.getAllInstance();
    }
}
