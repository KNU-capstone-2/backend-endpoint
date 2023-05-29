package com.knu.cloudapi.application.dto;

import lombok.Getter;

@Getter
public class Flavor {
    private Long id;
    private String name;
    private int cpu;
    private int ram;
    private int disk;
    private int rootDisk;
    private int ephemeral;
    private String visible;
}
