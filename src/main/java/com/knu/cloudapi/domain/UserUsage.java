package com.knu.cloudapi.domain;

import com.knu.cloudapi.application.dto.Flavor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserUsage {
    private Long id;
    private int vCpu;
    private int ram;
    private int hdd;
    private int instanceNum;

    /**
     * 사용량 추가
     * @param vCpu
     * @param ram
     * @param hdd
     * @param instanceNum
     */
    public void addUsage(int vCpu, int ram, int hdd, int instanceNum) {
        this.vCpu += vCpu;
        this.ram += ram;
        this.hdd += hdd;
        this.instanceNum += instanceNum;
    }

    /**
     * 사용량 감소
     * @param vCpu
     * @param ram
     * @param hdd
     * @param instanceNum
     */
    public void subUsage(int vCpu, int ram, int hdd, int instanceNum) {
        this.vCpu -= vCpu;
        this.ram -= ram;
        this.hdd -= hdd;
        this.instanceNum -= instanceNum;
    }

    public boolean cmpUsage(int vCpu, int ram, int hdd, Flavor flavor){
       return this.vCpu + flavor.getCpu() <= vCpu
               && this.ram + flavor.getRam() <= ram
               && this.hdd + flavor.getDisk() <= hdd;
    }
}
