package com.tickettogo.TicketToGoBackend.exception;

import java.sql.SQLIntegrityConstraintViolationException;

public class UserAlreadyExistsException extends SQLIntegrityConstraintViolationException {
    public UserAlreadyExistsException() {
        super("E-mail or Mobile Number already exists!");
    }
}
