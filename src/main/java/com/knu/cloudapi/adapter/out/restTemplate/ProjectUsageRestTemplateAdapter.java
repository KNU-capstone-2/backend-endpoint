package com.knu.cloudapi.adapter.out.restTemplate;

import com.knu.cloudapi.application.port.out.ProjectUsageRestTemplatePort;
import com.knu.cloudapi.domain.ProjectUsage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class ProjectUsageRestTemplateAdapter implements ProjectUsageRestTemplatePort {
    private final RestTemplate restTemplate;

    @Override
    public ProjectUsage getProjectUsage() {
        return restTemplate.getForObject("http://43.201.133.78:8000/project", ProjectUsage.class);
    }
}
