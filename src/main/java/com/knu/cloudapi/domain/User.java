package com.knu.cloudapi.domain;

import com.knu.cloudapi.common.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
public class User {
    private Long id;
    private String username;
    private String email;
    private String password;
    private Role role;

    public User(String username, String email, String password, Role role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public List<String> roles() {
        if (role.getKey().length() == 0) {
            return new ArrayList<>();
        }

        return Arrays.asList(role.getKey().split(","));
    }

}
