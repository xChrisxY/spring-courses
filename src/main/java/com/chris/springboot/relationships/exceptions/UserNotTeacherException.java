package com.chris.springboot.relationships.exceptions;

public class UserNotTeacherException extends RuntimeException{

    public UserNotTeacherException(String message){
        super(message);
    }

}
