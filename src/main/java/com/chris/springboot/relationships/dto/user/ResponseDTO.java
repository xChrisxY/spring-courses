package com.chris.springboot.relationships.dto.user;

public class ResponseDTO {

    private boolean success;
    private String message;
    private int status;
    private UserResponseDTO user;

    public ResponseDTO(){}

    public ResponseDTO(boolean success, String message, int status, UserResponseDTO user) {
        this.success = success;
        this.message = message;
        this.status = status;
        this.user = user;
    }

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


    public UserResponseDTO getUser() {
        return user;
    }

    public void setUser(UserResponseDTO user) {
        this.user = user;
    }
}
