package com.gunes.security.basicauth.dto;

import com.gunes.security.basicauth.model.Role;

import java.util.Set;

public record CreateUserRequest(
        String name,
        String username,
        String password,
        Set<Role> authorities

) {
}
