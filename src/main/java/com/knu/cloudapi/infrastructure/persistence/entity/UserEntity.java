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

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private Role role;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "user_usage_id")
  private UserUsageEntity userUsageEntity;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "user_role_id")
  private UserRoleEntity userRoleEntity;

  @OneToMany(mappedBy = "userEntity")
  private List<InstanceEntity> instanceList = new ArrayList<InstanceEntity>();

  public void setUserUsageEntity(UserUsageEntity userUsageEntity) {
    this.userUsageEntity = userUsageEntity;
    userUsageEntity.setUserEntity(this);
  }

  public void setUserRoleEntity(UserRoleEntity userRoleEntity) {
    this.userRoleEntity = userRoleEntity;
    userRoleEntity.setUserEntity(this);
  }

  public void addInstanceEntity(InstanceEntity instanceEntity) {
    instanceList.add(instanceEntity);
    instanceEntity.setUserEntity(this);
  }
}
