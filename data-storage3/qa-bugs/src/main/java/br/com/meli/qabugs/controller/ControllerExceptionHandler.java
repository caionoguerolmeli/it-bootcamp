package br.com.meli.qabugs.controller;

import br.com.meli.qabugs.exception.TestCaseNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.format.DateTimeParseException;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(TestCaseNotFound.class)
    protected ResponseEntity<?> testCaseNotFoundException(TestCaseNotFound e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(DateTimeParseException.class)
    protected ResponseEntity<?> dateTimeParseException(DateTimeParseException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Date format invalid");
    }
}
