package com.knu.cloudapi.domain;

import com.knu.cloudapi.application.dto.Flavor;
import lombok.Getter;

@Getter
public class ProjectUsage {
    private int instanceCount;
    private int vCpuCount;
    private int ramCount;
    private int volumeCount;
    private int snapshotCount;
    private int volumeStorageGB;
    private int floatingIpCount;
    private int securityGroupCount;
    private int networkCount;

    public boolean cmpProjectUsage(int instanceCount, int vCpuCount, int ramCount, int volumeCount, Flavor flavor) {
        return this.instanceCount + 1 <= instanceCount
                && this.vCpuCount + flavor.getCpu() <= vCpuCount
                && this.ramCount + flavor.getRam() <= ramCount
                && this.volumeCount + flavor.getDisk() <= volumeCount;
    }
}
