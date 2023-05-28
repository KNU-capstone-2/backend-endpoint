package com.knu.cloudapi.application.port.out;

import com.knu.cloudapi.application.dto.request.InstanceRequest;
import com.knu.cloudapi.domain.Instance;

import java.util.ArrayList;

public interface InstanceRestTemplatePort {
    Instance getInstance(String name);
    ArrayList<Instance> getAllInstance();
    Instance createInstance(InstanceRequest instanceRequest);

    String deleteInstance(String instanceName);
}
