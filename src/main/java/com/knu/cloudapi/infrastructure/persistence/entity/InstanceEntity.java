package com.knu.cloudapi.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "instance")
public class InstanceEntity {
    @Id @GeneratedValue
    @Column(name = "instance_id")
    private Long id;
    @Column(name = "instance")
    private String name;
    @Column(name = "access_role")
    private String accessRole;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;
}
