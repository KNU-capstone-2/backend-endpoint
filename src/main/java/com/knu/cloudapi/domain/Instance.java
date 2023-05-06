package com.knu.cloudapi.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Instance {
    private Long id;
    private String name;
    private String accessRole;
}
