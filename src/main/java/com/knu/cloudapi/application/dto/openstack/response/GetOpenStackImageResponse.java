package com.knu.cloudapi.application.dto.openstack.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class GetOpenStackImageResponse {

    private String id;

    private String name;

    private String createdDate;

    private String updateDate;

    private String size;

    private String status;
}
