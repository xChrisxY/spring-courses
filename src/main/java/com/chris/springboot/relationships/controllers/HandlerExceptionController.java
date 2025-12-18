package com.chris.springboot.relationships.controllers;

import com.chris.springboot.relationships.exceptions.UserNotFoundException;
import com.chris.springboot.relationships.exceptions.UserNotTeacherException;
import com.chris.springboot.relationships.exceptions.category.CategoryNotFoundException;
import com.chris.springboot.relationships.exceptions.course.CourseNotFoundException;
import com.chris.springboot.relationships.models.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class HandlerExceptionController {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Error> userNotFoundException(Exception e){

        Error error = new Error(
                "Usuario no encontrado",
                e.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                new Date()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error);
    }

    @ExceptionHandler(UserNotTeacherException.class)
    public ResponseEntity<Error> userNotTeacherException(Exception e){

        Error error = new Error(
            "El usuario dado no tiene el rol de profesor",
            e.getMessage(),
            HttpStatus.FORBIDDEN.value(),
                new Date()
        );

        return ResponseEntity.status(HttpStatus.FORBIDDEN.value()).body(error);
    }

    @ExceptionHandler(CourseNotFoundException.class)
    public ResponseEntity<Error> courseNotFound(Exception e){

        Error error = new Error(
                "Curso no encontrado",
                e.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                new Date()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error);
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<Error> categoryNotFound(Exception e){

        Error error = new Error(
                "La categoria no fue encontrada",
                e.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                new Date()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error);
    }
}
