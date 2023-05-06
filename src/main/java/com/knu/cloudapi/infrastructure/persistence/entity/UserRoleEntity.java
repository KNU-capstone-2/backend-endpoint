package com.knu.cloudapi.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Table(name="user_role")
@Getter @Setter
public class UserRoleEntity {
    @Id @GeneratedValue
    @Column(name = "user_role_id")
    private Long id;

    private String role;

    @Column(name = "max_vcpu")
    private int maxVCpu;
    @Column(name = "max_ram")
    private int maxRam;
    @Column(name = "max_hdd")
    private int maxHdd;

}
