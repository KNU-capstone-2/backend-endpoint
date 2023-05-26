package com.knu.cloudapi.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class InstanceResponse{
    private String instanceId;
    private String instanceName;
    private String publicIPv4Address;
    private String privateIPv4Address;
    private String instanceState;
    private String publicIPv4DNS;
    private String hostNameType;
    private String privateIpDnsName;
    private String instanceType;
    private String statusCheck;
}
