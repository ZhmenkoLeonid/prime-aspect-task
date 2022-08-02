package com.zhmenko.primeaspecttask.controllers;

import com.zhmenko.primeaspecttask.model.exceptions.BadRequestException;
import com.zhmenko.primeaspecttask.model.exceptions.CountriesNotFoundException;
import com.zhmenko.primeaspecttask.model.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler(CountriesNotFoundException.class)
    public ResponseEntity<Error> handleException(CountriesNotFoundException e) {
        return new ResponseEntity<>(new Error(HttpStatus.NOT_FOUND.value(), e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Error> handleException(BadRequestException e) {
        return new ResponseEntity<>(new Error(HttpStatus.BAD_REQUEST.value(), e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ConstraintViolationException.class, HttpMessageNotReadableException.class, MethodArgumentNotValidException.class, BindException.class})
    public ResponseEntity<Error> handleException(Exception e) {
        return new ResponseEntity<>(new Error(HttpStatus.BAD_REQUEST.value(), "Validation Failed"), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<String> handleException(HttpClientErrorException e) {
        return new ResponseEntity<>("Client Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handleDefaultException(Exception e){
        return new ResponseEntity<>(new Error(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}