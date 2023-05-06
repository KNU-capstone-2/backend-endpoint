package com.knu.cloudapi.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Table(name="user_usage")
@Getter @Setter
public class UserUsageEntity {
    @Id @GeneratedValue
    @Column(name = "user_usage_id")
    private Long id;
    @Column(name = "vcpu")
    private int vCpu;
    private int ram;
    private int hdd;
}
