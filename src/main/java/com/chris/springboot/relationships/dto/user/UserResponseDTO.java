package com.chris.springboot.relationships.dto.user;

import com.chris.springboot.relationships.enums.Role;
import com.chris.springboot.relationships.models.UserProfile;

public class UserResponseDTO {

    private String username;
    private String email;
    private Role role;
    private UserProfileCreateDTO profile;

    public UserResponseDTO(){}

    public UserResponseDTO(String username, String email, Role role, UserProfileCreateDTO profile) {
        this.username = username;
        this.email = email;
        this.role = role;
        this.profile = profile;
    }

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
