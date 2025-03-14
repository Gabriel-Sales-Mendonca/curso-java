package com.gabrielsales.workshop.controllers.exceptions;

import com.gabrielsales.workshop.services.exceptions.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import jdk.jshell.Snippet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {

        String err = "Não encontrado!";
        HttpStatus status = HttpStatus.NOT_FOUND;

        StandardError error = new StandardError(Instant.now(), status.value(), err, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }

}
