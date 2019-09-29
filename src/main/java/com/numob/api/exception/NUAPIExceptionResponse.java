package com.numob.api.exception;

import org.springframework.web.servlet.NoHandlerFoundException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NUAPIExceptionResponse {
    public String timestamp;
    public int status;
    public String error;
    public String message;
    public String path;

    public NUAPIExceptionResponse(NUAPIException e, String path) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.SSSZ");
        this.message = e.message;
        this.error = e.error;
        this.status = e.status;
        this.timestamp = df.format(new Date());
        this.path = path;
    }


    /**
     * For 404 Not found handling.
     * Should add following two config in application.properties to disable the system default 404 handling
     * spring.mvc.throw-exception-if-no-handler-found=true
     * spring.resources.add-mappings=false
     */
    public NUAPIExceptionResponse(NoHandlerFoundException e, String path) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.SSSZ");
        this.message = "";
        this.error = e.getMessage();
        this.status = 404;
        this.timestamp = df.format(new Date());
        this.path = path;
    }

    public NUAPIExceptionResponse(Exception e, String path) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.SSSZ");
        this.message = "";
        this.error = e.getMessage();
        this.status = 500;
        this.timestamp = df.format(new Date());
        this.path = path;
    }

}
