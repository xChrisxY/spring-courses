package com.chris.springboot.relationships.exceptions.lessons;

public class LessonNotFoundException extends RuntimeException{

    public LessonNotFoundException(String message){
        super(message);
    }
}
