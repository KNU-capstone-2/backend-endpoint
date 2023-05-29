package com.knu.cloudapi.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class InstanceResponse{

    private Long id;

    private String creatorName;

    private String instanceId;

    private String instanceName;

    private String instanceStatus;

    private String hostNameType;

    private String securityGroups;

    private String instanceType;

    private String createdDate;

    private String networkName;

    private String networkAddresses;

    private String keypairName;

    private String powerState;

    private String taskState;

    private String imageName;
}
