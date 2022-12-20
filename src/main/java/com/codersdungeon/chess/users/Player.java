package com.codersdungeon.chess.users;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Player {
    @Id
    @Column(length = 50)
    private String username;

    @Column(length = 500, nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<UserRole> roles;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<UserRole> roles) {
        this.roles = roles;
    }

    public void addRole(UserRole role){
        if(this.roles == null){
            this.roles = new HashSet<>();
        }
        this.roles.add(role);
    }

    @Override
    public String toString() {
        return "Player{" +
                "username='" + username + '\'' +
                ", password=[PROTECTED]" +
                ", enabled=" + enabled +
                ", roles=" + roles +
                '}';
    }
}
