package com.numob.api.exception;

/**
 * Throw this exception when you need to force logout a user by sending out 401 by handler
 */
public class NUAPIAuthException extends NUAPIException{

    public NUAPIAuthException() {
        super();
        this.status = 401;
    }

    public NUAPIAuthException(String message) {
        super(message);
        this.status = 401;
    }

    public NUAPIAuthException(String message, String error) {
        super(message, error, 401);
    }

}
