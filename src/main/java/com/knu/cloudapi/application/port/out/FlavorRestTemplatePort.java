package com.knu.cloudapi.application.port.out;

import com.knu.cloudapi.application.dto.Flavor;

public interface FlavorRestTemplatePort {
    Flavor getFlavor(String name);

}
