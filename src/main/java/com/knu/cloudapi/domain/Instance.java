package com.knu.cloudapi.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class Instance {
    private Long id;

    private String accessRole;

    private String instanceName;

    private String instanceId;

    private String publicIPv4Address;

    private String privateIPv4Address;

    private String instanceState;

    private String publicIPv4DNS;

    private String hostNameType;

    private String privateIpDnsName;

    private String instanceType;

    private String statusCheck;
}
