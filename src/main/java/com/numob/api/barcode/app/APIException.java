package com.numob.api.barcode.app;

/**
 * The base Numob API exception with default status 300 (API Operation failed.)
 */
public class APIException extends RuntimeException {
    private String message;  //message displayed to end user
    private String error;  //message for developer debug purpose

    public APIException() {
        super();
    }

    /**
     * Show message to user and also show message to developer with default status 300
     * @param message displayed message to user and developer
     */
    public APIException(String message) {
        super(message);
        this.message = message;
        this.error = message;
    }

    /**
     * Show message to user and also show error to developer with default status 300
     * @param message displayed message to user
     * @param error displayed error to developer
     */
    public APIException(String message, String error) {
        super(message);
        this.message = message;
        this.error = error;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public String getError() {
        return error;
    }
}
