package com.noname.global.exception;

public class UnAuthenticationException extends RuntimeException {
    public UnAuthenticationException(final String message) {
        super(message);
    }
}
