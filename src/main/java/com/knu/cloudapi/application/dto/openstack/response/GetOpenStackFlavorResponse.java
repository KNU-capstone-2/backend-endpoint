package com.knu.cloudapi.application.dto.openstack.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class GetOpenStackFlavorResponse {

    private String id;

    private String name;

    private String vcpus;

    private String ram;

    private String disk;

    private Integer rootDisk;

    private String ephemeral;

    private String visibale;
}
