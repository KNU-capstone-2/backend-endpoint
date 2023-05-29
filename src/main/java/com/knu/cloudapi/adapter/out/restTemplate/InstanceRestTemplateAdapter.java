package com.knu.cloudapi.adapter.out.restTemplate;

import com.knu.cloudapi.application.dto.request.InstanceRequest;
import com.knu.cloudapi.application.dto.response.InstanceResponse;
import com.knu.cloudapi.application.port.out.InstanceRestTemplatePort;
import com.knu.cloudapi.domain.Instance;
import com.knu.cloudapi.infrastructure.persistence.mapper.InstanceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class InstanceRestTemplateAdapter implements InstanceRestTemplatePort {

    private final RestTemplate restTemplate;
    private final InstanceMapper instanceMapper;

    @Override
    public Instance getInstance(String name) {
        try {
            return instanceMapper.fromResponseDto(restTemplate.getForObject("http://43.201.133.78:8000/instance/{name}", InstanceResponse.class, name));
        } catch (HttpClientErrorException e) {
            return null;
        }
    }

    @Override
    public ArrayList<Instance> getAllInstance() {
        ArrayList<InstanceResponse> instanceResponses = restTemplate.exchange(
                "http://43.201.133.78:8000/instances",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<ArrayList<InstanceResponse>>() {}
        ).getBody();


        ArrayList<Instance> instances = new ArrayList<>();
        if (instanceResponses != null) {
            for (InstanceResponse instanceResponse : instanceResponses) {
                instances.add(instanceMapper.fromResponseDto(instanceResponse));
            }
        }
        return instances;
    }

    @Override
    public Instance createInstance(InstanceRequest instanceRequest) {
        return restTemplate.postForObject("http://43.201.133.78:8000/instance", instanceRequest, Instance.class);
    }

    @Override
    public String deleteInstance(String instanceName) {
        return restTemplate.exchange(
                "http://43.201.133.78:8000/instance/{instanceName}",
                HttpMethod.DELETE,
                null,
                String.class,
                instanceName
        ).getBody();
    }
}
