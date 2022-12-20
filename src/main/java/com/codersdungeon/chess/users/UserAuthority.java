package com.codersdungeon.chess.users;

import org.springframework.security.core.GrantedAuthority;

public class UserAuthority implements GrantedAuthority {
    private final UserRole userRole;

    public UserAuthority(UserRole userRole) {
        this.userRole = userRole;
    }

    @Override
    public String getAuthority() {
        return userRole.getAuthority();
    }

    @Override
    public String toString() {
        return "UserAuthority{" +
                "userRole=" + userRole +
                '}';
    }
}