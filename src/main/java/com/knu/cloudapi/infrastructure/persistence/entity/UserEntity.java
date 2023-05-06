package com.knu.cloudapi.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Table(name="user_schema")
@Getter @Setter
public class UserEntity {
  @Id @GeneratedValue
  @Column(name = "user_id")
  private Long id;

  private String email;

  private String username;

  private String password;

  private String role;

  @OneToOne
  @JoinColumn(name = "user_usage_id")
  private UserEntity userUsageEntity;

  @OneToOne
  @JoinColumn(name = "user_role_id")
  private UserEntity userRoleEntity;

  @OneToMany(mappedBy = "userEntity")
  private List<InstanceEntity> instanceList = new ArrayList<InstanceEntity>();
}
