package com.example.fashionblogapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
        @ExceptionHandler(value = {CustomRequestException.class})
        public ResponseEntity<Object> handleApiRequestException(CustomRequestException e){
            //create payload containing exception details
            //return response entity
            HttpStatus badRequest = HttpStatus.BAD_REQUEST;
            CustomException apiException = new CustomException(
                    e.getMessage(),
                    badRequest,
                    ZonedDateTime.now(ZoneId.of("Z"))
            );
            return new ResponseEntity<>(apiException, badRequest);
        }
    }

