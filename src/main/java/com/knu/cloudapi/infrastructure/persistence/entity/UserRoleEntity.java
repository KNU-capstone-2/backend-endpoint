package com.knu.cloudapi.infrastructure.persistence.entity;

import com.knu.cloudapi.common.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Table(name="user_role")
@Getter @Setter
public class UserRoleEntity {
    @Id
    @Column(name = "user_role_id")
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "max_vcpu")
    private int maxVCpu;

    @Column(name = "max_ram")
    private int maxRam;

    @Column(name = "max_hdd")
    private int maxHdd;

    @OneToOne(mappedBy = "userRoleEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private UserEntity userEntity;


    public UserRoleEntity(Role role, int maxVCpu, int maxRam, int maxHdd) {
        this.role = role;
        this.maxVCpu = maxVCpu;
        this.maxRam = maxRam;
        this.maxHdd = maxHdd;
    }
}
