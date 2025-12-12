package com.chris.springboot.relationships.dto.user;

import com.chris.springboot.relationships.enums.Role;

public class UserCreateDTO {

    private String username;
    private String email;
    private String password;
    private Role role;
    private UserProfileCreateDTO profile;

    public UserCreateDTO(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String passwordHash) {
        this.password = passwordHash;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public UserProfileCreateDTO getProfile() {
        return profile;
    }

    public void setProfile(UserProfileCreateDTO profile) {
        this.profile = profile;
    }
}
