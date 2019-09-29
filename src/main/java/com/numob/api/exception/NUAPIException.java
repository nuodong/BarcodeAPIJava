package com.numob.api.exception;

/**
 * The base Numob API exception with default status 300 (API Operation failed.)
 */
public class NUAPIException extends Exception {
    public String message = "";  //message displayed to end user
    public String error = "";  //message for developer debug purpose
    public int status = 300;  // The http status code default to 300

    public NUAPIException() {
        super();
    }

    /**
     * Show message to user and also show message to developer with default status 300
     * @param message displayed message to user and developer
     */
    public NUAPIException(String message) {
        super(message);
        this.message = message;
        this.error = message;
    }

    /**
     * Show message to user and also show error to developer with default status 300
     * @param message displayed message to user
     * @param error displayed error to developer
     */
    public NUAPIException(String message, String error) {
        super(message);
        this.message = message;
        this.error = error;
    }

    /**
     * Show message to user and also show error to developer
     * @param message displayed message to user
     * @param error displayed error to developer
     */
    public NUAPIException(String message, String error, int status) {
        super(message);
        this.message = message;
        this.error = error;
        this.status = status;
    }

}
