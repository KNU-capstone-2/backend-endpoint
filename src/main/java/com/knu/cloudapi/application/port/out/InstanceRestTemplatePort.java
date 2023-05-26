package com.knu.cloudapi.application.port.out;

import com.knu.cloudapi.application.dto.response.InstanceResponse;
import com.knu.cloudapi.domain.Instance;

import java.util.ArrayList;

public interface InstanceRestTemplatePort {
    Instance getInstance(String name);
    ArrayList<Instance> getAllInstance();
}
