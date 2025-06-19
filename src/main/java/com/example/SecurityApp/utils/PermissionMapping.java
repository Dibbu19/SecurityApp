package com.example.SecurityApp.utils;

import com.example.SecurityApp.enums.Permission;
import com.example.SecurityApp.enums.Role;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.example.SecurityApp.enums.Permission.*;
import static com.example.SecurityApp.enums.Role.*;


public class PermissionMapping {

    private static final Map<Role, Set<Permission>> map = Map.of(
            USER,Set.of(USER_VIEW,POST_VIEW),
            Creator,Set.of(POST_CREATE,USER_UPDATE,POST_UPDATE),
            ADMIN,Set.of(POST_CREATE,USER_UPDATE,POST_UPDATE,USER_CREATE,USER_DELETE,USER_VIEW,POST_VIEW)
    );

    public static Set<SimpleGrantedAuthority> getAuthority(Role role) {
        return map.get(role).stream()
                .map(permission -> new SimpleGrantedAuthority(permission.name()))
                .collect(Collectors.toSet());
    }
}
