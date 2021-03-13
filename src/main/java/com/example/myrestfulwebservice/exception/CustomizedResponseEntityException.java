package com.example.myrestfulwebservice.exception;

import com.example.myrestfulwebservice.controller.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestController // 웹 서비스에서 사용할 수 있도록 선언
@RestControllerAdvice // 해당 컨트롤러가 사전에 실행될 수 있도록
public class CustomizedResponseEntityException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        ExceptionResponseEntity exceptionResponseEntity
                = new ExceptionResponseEntity(new Date(), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity(exceptionResponseEntity, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest request) {
        ExceptionResponseEntity responseEntity
                = new ExceptionResponseEntity(new Date(), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity(responseEntity, HttpStatus.NOT_FOUND);
    }

}
