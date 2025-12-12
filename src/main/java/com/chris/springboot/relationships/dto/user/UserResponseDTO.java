package com.chris.springboot.relationships.dto.user;

import com.chris.springboot.relationships.models.User;

public class UserResponseDTO {

    private boolean success;
    private String message;
    private int status;
    private User user;

    public UserResponseDTO(){}

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
