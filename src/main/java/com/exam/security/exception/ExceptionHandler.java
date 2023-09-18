package com.exam.security.exception;

import com.exam.security.exception.login.IdDuplicateException;
import com.exam.security.exception.login.ErrorCode;
import com.exam.security.exception.login.ErrorResponse;
import com.exam.security.exception.login.ForbiddenException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(IdDuplicateException.class)
    public ResponseEntity<ErrorResponse> handleEmailDuplicateException(IdDuplicateException e){
        log.error("EmailDuplicate Exception",e);
        ErrorResponse response = new ErrorResponse(ErrorCode.ID_DUPLICATE);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<ErrorResponse> handleForbiddenException(ForbiddenException e){
        log.error("Forbidden Exception", e);
        ErrorResponse response = new ErrorResponse(ErrorCode.FORBIDDEN_ERROR);
        return ResponseEntity.status(response.getStatus()).body(response);
    }
}
