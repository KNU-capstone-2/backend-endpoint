package com.knu.cloudapi.adapter.out.resttemplate;

import com.knu.cloudapi.application.dto.Flavor;
import com.knu.cloudapi.application.port.out.FlavorRestTemplatePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class FlavorRestTemplateAdapter implements FlavorRestTemplatePort {
    private final RestTemplate restTemplate;

    @Override
    public Flavor getFlavor(String name) {
        return restTemplate.getForObject("http://43.201.133.78:8000/flavor/{name}", Flavor.class, name);
    }
}
