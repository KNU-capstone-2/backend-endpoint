package com.knu.cloudapi.application.port.in;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetProjectResponse {
    private Integer instanceCount;

    private Integer vcpuCount;

    private Integer ramCount;

    private Integer volumeCount;

    private Integer snapshotCount;

    private Integer volumeStorageGB;

    private Integer floatingIpCount;

    private Integer securityGroupCount;

    private Integer networkCount;
}
