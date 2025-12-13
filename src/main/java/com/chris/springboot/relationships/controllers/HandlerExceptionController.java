package com.chris.springboot.relationships.controllers;

import com.chris.springboot.relationships.exceptions.UserNotFoundException;
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

}
