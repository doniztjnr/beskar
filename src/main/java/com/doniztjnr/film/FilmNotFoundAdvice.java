package com.doniztjnr.film;

/*
 * A 404 not found error is an HTTP status code that means that
 *  the page couldn't be found on server.
 * */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class FilmNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(FilmNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String FilmNotFoundHandler(FilmNotFoundException exception) {
        return exception.getMessage();
    }
}
