package com.springtest.ws.exceptions;

public class UserServiceException extends RuntimeException {

    private final long serialVersionUID = 106875132741351356L;

    public UserServiceException(String message) {
        super(message);
    }
}
