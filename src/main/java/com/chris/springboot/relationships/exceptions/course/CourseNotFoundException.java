package com.chris.springboot.relationships.exceptions.course;

public class CourseNotFoundException extends RuntimeException{

    public CourseNotFoundException(String message){
        super(message);
    }

}
