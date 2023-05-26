package com.knu.cloudapi.application.port.out;

import com.knu.cloudapi.domain.Instance;

public interface InstancePersistencePort {
    Instance getInstanceById(Long id);
}
