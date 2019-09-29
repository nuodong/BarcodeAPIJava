package com.numob.api.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

/**
 * To have this package be scanned, make sure to add @ComponentScan(basePackages = "com.numob.api") to @SpringBootApplication
 *
 */
@RestControllerAdvice

public class NUAPIExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(NUAPIExceptionHandler.class);

    @ExceptionHandler(NUAPIException.class)
    public NUAPIExceptionResponse handleNUAPIException(HttpServletRequest request, NUAPIException e) {
        logger.error("Exception path: " + request.getRequestURI());
        String path = request.getRequestURI();
        e.printStackTrace();
        return new NUAPIExceptionResponse(e, path);
    }

    @ExceptionHandler(RuntimeException.class)
    public NUAPIExceptionResponse handleRuntimeException(HttpServletRequest request, RuntimeException e) {
        logger.error("Exception path: " + request.getRequestURI());
        String path = request.getRequestURI();
        return new NUAPIExceptionResponse(e, path);
    }

    @ExceptionHandler(Exception.class)
    public NUAPIExceptionResponse handleException(HttpServletRequest request, Exception e) {
        logger.error("Exception path: " + request.getRequestURI());
        String path = request.getRequestURI();
        return new NUAPIExceptionResponse(e, path);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public NUAPIExceptionResponse handleNoHandlerFoundException(HttpServletRequest request, NoHandlerFoundException e) {
        logger.error("Exception path: " + request.getRequestURI());
        String path = request.getRequestURI();
        return new NUAPIExceptionResponse(e, path);
    }
}
