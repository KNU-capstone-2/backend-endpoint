package com.knu.cloudapi.application.dto.openstack.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class GetOpenStackNetworkResponse {

    private String id;

    private String name;

    private String shared;

    private String external;

    private String adminState;

    private String availabilityZone;

    private String subnets;
}
