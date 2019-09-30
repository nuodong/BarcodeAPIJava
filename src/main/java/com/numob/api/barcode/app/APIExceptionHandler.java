package com.numob.api.barcode.app;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Our own exception handler for all exceptions, including 404
 *
 */
@RestControllerAdvice
public class APIExceptionHandler {
    // Handle NUAPIException (General Operation Failed)
    @ExceptionHandler(APIException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)  //400
    public void handle(HttpServletRequest request, HttpServletResponse response, APIException e) {
        e.printStackTrace();
        APIResponseUtil.addErrorHeader(response, e.getError());
        APIResponseUtil.addMessageHeader(response, e.getMessage());
    }

    // Handle NUAPILoginRequiredException
    @ExceptionHandler(LoginRequiredException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)  //401
    public void handle(HttpServletRequest request, HttpServletResponse response, LoginRequiredException e) {
        e.printStackTrace();
        APIResponseUtil.addErrorHeader(response, e.getError());
        APIResponseUtil.addMessageHeader(response, e.getMessage());
    }

    // Handle NoHandlerFoundException (404 not found)
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)  //404
    public void handle(HttpServletRequest request, HttpServletResponse response, NoHandlerFoundException e) {
        e.printStackTrace();
        APIResponseUtil.addErrorHeader(response, e.getMessage());
    }

    // Handle General Exception
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)  //500
    public void handle(HttpServletRequest request, HttpServletResponse response, Exception e) {
        e.printStackTrace();
        APIResponseUtil.addErrorHeader(response, e.getMessage());
    }

}
