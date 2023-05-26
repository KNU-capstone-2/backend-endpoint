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

  @Column(unique = true, nullable = false)
  private String email;

  @Column(unique = true, nullable = false)
  private String username;

  @Column(nullable = false)
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
