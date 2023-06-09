package com.example.fashionblogapi.exceptions;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class CustomException extends RuntimeException{
        private final String message;
        private final HttpStatus httpStatus;
        private final ZonedDateTime timeStamp;
        public CustomException(String message, HttpStatus httpStatus, ZonedDateTime timeStamp) {
            this.message = message;
            this.httpStatus = httpStatus;
            this.timeStamp = timeStamp;
        }
        public String getMessage() {
            return message;
        }
        public HttpStatus getHttpStatus() {
            return httpStatus;
        }
        public ZonedDateTime getTimeStamp() {
            return timeStamp;
        }
    }

