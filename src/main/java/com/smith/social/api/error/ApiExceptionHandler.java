package com.smith.social.api.error;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler{
    
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFound(UserNotFoundException ext){
        
        return ResponseEntity.status(ext.getStatusCode()).body(ext.getMessage());

    }

    @ExceptionHandler(DatabaseManipulationException.class)
    public ResponseEntity<String> handleUserNotFound(DatabaseManipulationException ext){
        
        return ResponseEntity.status(ext.getStatusCode()).body(ext.getMessage());

    }
}
