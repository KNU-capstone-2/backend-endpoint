package com.knu.cloudapi.application.port.in;

import com.knu.cloudapi.domain.Instance;

import java.util.ArrayList;

public interface InstanceUseCase {
    Instance getInstance(Long id);
    ArrayList<Instance> getAllInstance();
}
