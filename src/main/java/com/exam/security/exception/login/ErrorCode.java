package com.exam.security.exception.login;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    NOT_FOUND(HttpStatus.NOT_FOUND,"COMMON-ERR-404","PAGE NOT FOUND"),
    INTER_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR,"COMMON-ERR-500","INTER SERVER ERROR"),
    ID_DUPLICATE(HttpStatus.BAD_REQUEST,"MEMBER-ERR-400","ID DUPLICATED"),
    FORBIDDEN_ERROR(HttpStatus.FORBIDDEN,"MEMBER-ERR-403","FORBIDDEN ERROR"),
    JWT_ERROR(HttpStatus.UNAUTHORIZED, "JWT-ERR-401", "JWT ERROR"),
    ;
    private HttpStatus status;
    private String errorCode;
    private String message;

}
