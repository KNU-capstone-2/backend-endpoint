package com.knu.cloudapi.application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class InstanceRequest {
    private String serverName;
    private String imageName;
    private String flavorName;
    private String networkName;
    private String keypairName;
}
