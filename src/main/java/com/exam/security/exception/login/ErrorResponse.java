package com.exam.security.exception.login;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ErrorResponse {
    private HttpStatus status;
    private String message;
    private String code;

    public ErrorResponse(HttpStatus status, String message, String code) {
        this.status = status;
        this.message = message;
        this.code = code;
    }

    public ErrorResponse(ErrorCode errorCode){
        this.status = errorCode.getStatus();
        this.message = errorCode.getMessage();
        this.code = errorCode.getErrorCode();
    }

}
