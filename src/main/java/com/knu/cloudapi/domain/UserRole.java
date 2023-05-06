package com.knu.cloudapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class UserRole {
    private Long id;
    private String role;
    private int maxVCpu;
    private int maxRam;
    private int maxHdd;
}
