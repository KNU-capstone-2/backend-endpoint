package com.knu.cloudapi.infrastructure.persistence.entity;

import com.knu.cloudapi.common.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "userRoleEntity")
    private List<UserEntity> userEntityList = new ArrayList<UserEntity>();


    public UserRoleEntity(Role role, int maxVCpu, int maxRam, int maxHdd) {
        this.role = role;
        this.maxVCpu = maxVCpu;
        this.maxRam = maxRam;
        this.maxHdd = maxHdd;
    }

    public void addUserEntity(UserEntity userEntity) {
        this.userEntityList.add(userEntity);
        userEntity.setUserRoleEntity(this);
    }
}
