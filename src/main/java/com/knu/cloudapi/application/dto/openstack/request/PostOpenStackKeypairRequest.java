package com.knu.cloudapi.application.dto.openstack.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PostOpenStackKeypairRequest {
    private String keypairName;

    private String keypairType;
}
