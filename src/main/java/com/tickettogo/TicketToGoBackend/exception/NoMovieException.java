package com.tickettogo.TicketToGoBackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoMovieException extends RuntimeException{
    public NoMovieException(){
        super("No movies found!");
    }
}
