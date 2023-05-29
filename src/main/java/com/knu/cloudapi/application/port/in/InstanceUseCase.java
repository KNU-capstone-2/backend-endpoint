package com.knu.cloudapi.application.port.in;

import com.knu.cloudapi.application.dto.request.InstanceRequest;
import com.knu.cloudapi.application.dto.response.InstanceControlResponse;
import com.knu.cloudapi.domain.Instance;
import com.knu.cloudapi.domain.User;

import java.util.ArrayList;

public interface InstanceUseCase {
    Instance getInstance(Long id);
    ArrayList<Instance> getAllInstance();

    Instance createInstance(InstanceRequest instanceRequest, User user);

    boolean deleteInstance(Long id, User user);

    InstanceControlResponse startInstance(String id);

    InstanceControlResponse rebootInstance(String id);

    InstanceControlResponse stopInstance(String id);
}
