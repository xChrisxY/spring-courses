package com.chris.springboot.relationships.dto.user;

public class DeleteResponseDTO {

    private boolean success = true;
    private String message = "Usuario eliminado satisfactoriamente";
    private int status = 200;

    public DeleteResponseDTO() {
    }

    public DeleteResponseDTO(String message, int status, boolean success) {
        this.message = message;
        this.status = status;
        this.success = success;
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
}
