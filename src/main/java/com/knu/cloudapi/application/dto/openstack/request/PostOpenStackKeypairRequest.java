package com.knu.cloudapi.application.dto.openstack.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class PostOpenStackKeypairRequest {
    private String keypairName;

    private String keypairType;
}
