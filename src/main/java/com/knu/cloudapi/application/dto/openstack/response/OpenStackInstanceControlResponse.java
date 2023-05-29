package com.knu.cloudapi.application.dto.openstack.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class OpenStackInstanceControlResponse {
    private boolean isSuccess;

    private String message;
}
