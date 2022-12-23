package com.codersdungeon.chess.users;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Player {
    @Id
    @Column(length = 50)
    private String email;

    @Column(length = 500, nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean enabled;

    @Column (length = 50, unique = true)
    private String nickname;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<UserRole> roles;

    public String getEmail() {
        return email;
    }

    public void setEmail(String username) {
        this.email = username;
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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
                "username='" + email + '\'' +
                ", password=[PROTECTED]" +
                ", enabled=" + enabled +
                ", roles=" + roles +
                '}';
    }
}
