package com.codersdungeon.chess.users;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity(name="authorities")
public class UserRole {
    @Id
    private String authority;

    public UserRole() {
    }

    public UserRole(String authority) {
        this.authority = "ROLE_" + authority;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRole userRole = (UserRole) o;
        return Objects.equals(authority, userRole.authority);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authority);
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "authority='" + authority + '\'' +
                '}';
    }
}
