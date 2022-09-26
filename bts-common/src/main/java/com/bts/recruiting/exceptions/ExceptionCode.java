package com.bts.recruiting.exceptions;

import org.springframework.http.HttpStatus;

public enum ExceptionCode {

    INCORRECT_VALUE(HttpStatus.BAD_REQUEST),
    DUPLICATED_RECORD(HttpStatus.FOUND),
    RECORD_NOT_FOUND(HttpStatus.NOT_FOUND),
    CONFLICT(HttpStatus.CONFLICT),
    RECORD_NOT_EMPTY(HttpStatus.UNPROCESSABLE_ENTITY),
    FORBIDDEN(HttpStatus.FORBIDDEN);

    private final HttpStatus httpStatus;

    ExceptionCode(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public HttpStatus getStatus() {
        return httpStatus;
    }
}
