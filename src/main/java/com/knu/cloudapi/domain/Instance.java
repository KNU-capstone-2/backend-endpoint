package com.knu.cloudapi.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class Instance {
    private Long id;

    //==instanceRestTemplate Data==//
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

    //==instanceRequest Data==//
    private String imageName;

    private String flavorName;
}
