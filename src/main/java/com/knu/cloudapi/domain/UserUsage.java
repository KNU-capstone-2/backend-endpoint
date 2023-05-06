package com.knu.cloudapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter @Setter
@NoArgsConstructor
public class UserUsage {
    private Long id;
    private int vCpu;
    private int ram;
    private int hdd;
}
