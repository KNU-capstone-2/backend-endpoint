package com.knu.cloudapi.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="my_user")
@NoArgsConstructor
@Setter @Getter
public class UserEntity {
  @Id @GeneratedValue
  private Long id;

  private String email;

  private String username;

  private String password;

  private String role;

  private String userGroup;
}
