package com.bts.recruiting.exceptions;

import org.springframework.http.HttpStatus;

public class BtsException extends RuntimeException{
    private final HttpStatus httpStatus;

    public BtsException(ExceptionCode exceptionCode) {
        super(exceptionCode.name());
        httpStatus = exceptionCode.getStatus();
    }

    public BtsException(ExceptionCode exceptionCode, String causeMessage) {
        super(String.format("%s. %s", exceptionCode.name(), causeMessage));
        httpStatus = exceptionCode.getStatus();
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
