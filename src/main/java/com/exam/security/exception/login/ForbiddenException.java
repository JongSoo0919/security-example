package com.exam.security.exception.login;

public class ForbiddenException extends RuntimeException{
    private ErrorCode errorCode;

    public ForbiddenException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
