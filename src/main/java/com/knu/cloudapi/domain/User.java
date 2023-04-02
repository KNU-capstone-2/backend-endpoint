package com.knu.cloudapi.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.*;

@Setter @Getter
@NoArgsConstructor
public class User {
  private Long id;
  private String email;

  private String username;

  private String password;

  private String role;

  private String userGroup;

  public User(String email, String username, String password, String role, String userGroup) {
    this.email = email;
    this.username = username;
    this.password = password;
    this.role = role;
    this.userGroup = userGroup;
  }

  public List<String> roles() {
    if(role.length() == 0) {
      return new ArrayList<>();
    }

    return Arrays.asList(role.split(","));
  }

}
