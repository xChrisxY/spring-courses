package com.chris.springboot.relationships.dto.user;

import java.util.ArrayList;
import java.util.List;

public class ListResponseDTO {

    private boolean success;
    private String message;
    private int status;
    private List<UserResponseDTO> users;

    public ListResponseDTO(){
        this.users = new ArrayList<>();
    }

    public ListResponseDTO(boolean success, String message, int status, List<UserResponseDTO> users) {
        this();
        this.success = success;
        this.message = message;
        this.status = status;
        this.users = users;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<UserResponseDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserResponseDTO> users) {
        this.users = users;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
