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

    @Column(name = "instance_name", unique = true)
    private String instanceName;

    @Column(name = "image_name")
    private String imageName;

    @Column(name = "flavor_name")
    private String flavorName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;
}
