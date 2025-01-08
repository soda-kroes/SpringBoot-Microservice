package com.soda.bank.controller;

import com.soda.bank.exception.AlreadyExistException;
import com.soda.bank.exception.BadRequestException;
import com.soda.bank.exception.NotFoundException;
import com.soda.bank.response.MandatoryResponse;
import com.soda.bank.response.StatusResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(Exception ex) {
        StatusResponse response = new StatusResponse();
        response.setCode(500);
        response.setMessage(ex.getMessage());
        return ResponseEntity.status(500).body(response);
    }

    @ExceptionHandler(AlreadyExistException.class)
    public ResponseEntity<?> handleAlreadyExistException(AlreadyExistException ex) {
        StatusResponse response = new StatusResponse();
        response.setCode(409);
        response.setMessage(ex.getMessage());
        return ResponseEntity.status(409).body(response);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleNotFoundException(NotFoundException ex) {
        StatusResponse response = new StatusResponse();
        response.setCode(404);
        response.setMessage(ex.getMessage());
        return ResponseEntity.status(404).body(response);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> handleBadRequestException(BadRequestException ex) {
        StatusResponse response = new StatusResponse();
        response.setCode(400);
        response.setMessage(ex.getMessage());
        return ResponseEntity.status(400).body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        MandatoryResponse response = new MandatoryResponse();
        response.setCode(400);
        response.setMessage("Validation failed");
        response.setErrors(errors);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
