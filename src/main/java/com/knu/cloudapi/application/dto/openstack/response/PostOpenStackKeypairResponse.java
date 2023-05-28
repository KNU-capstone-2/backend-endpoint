package com.knu.cloudapi.application.dto.openstack.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
public class PostOpenStackKeypairResponse {

    private String name;

    private String type;

    private String fingerprint;

    private String privateKey;

}
