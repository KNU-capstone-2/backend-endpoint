package com.knu.cloudapi.infrastructure.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="user")
@Setter @Getter
public class UserEntity {
  @Id
  private Long id;

  private String username;

  private String password;

  private String role;

  private String userGroup;
}
