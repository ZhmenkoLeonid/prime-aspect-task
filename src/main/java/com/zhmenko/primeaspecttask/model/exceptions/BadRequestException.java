package com.zhmenko.primeaspecttask.model.exceptions;

public class BadRequestException extends RuntimeException {
    public BadRequestException() {
        super("Bad request!");
    }
}
