package com.stacksmplify.restservices.springbootbuildingblocks.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class CustomGlobalExcceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        CustomErrorDetails ced=new CustomErrorDetails(new Date(),"From MethodArgumentNotValid Exception",ex.getMessage());
        return new ResponseEntity<>(ced,HttpStatus.BAD_REQUEST);
    }

    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        pageNotFoundLogger.warn(ex.getMessage());
        CustomErrorDetails ced=new CustomErrorDetails(new Date(),"Http method not supported",ex.getMessage());
        return new ResponseEntity<>(ced,HttpStatus.METHOD_NOT_ALLOWED);
    }

    public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex,WebRequest request)
    {
        CustomErrorDetails ced=new CustomErrorDetails(new Date(),"User Not Found",ex.getMessage());
        return new ResponseEntity<>(ced,HttpStatus.NOT_FOUND);
    }

}
