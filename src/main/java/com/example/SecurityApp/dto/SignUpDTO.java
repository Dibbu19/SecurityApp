package com.example.SecurityApp.dto;

import com.example.SecurityApp.enums.Permission;
import com.example.SecurityApp.enums.Role;
import lombok.Data;

import java.util.Set;

@Data
public class SignUpDTO {
    private String email;
    private String name;
    private String password;
    private Set<Role> roles;
    private Set<Permission> permissions;
}
