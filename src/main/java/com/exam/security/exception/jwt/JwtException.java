package com.exam.security.exception.jwt;

import com.exam.security.exception.login.ErrorCode;

public class JwtException extends RuntimeException{
    private ErrorCode errorCode;

    public JwtException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
