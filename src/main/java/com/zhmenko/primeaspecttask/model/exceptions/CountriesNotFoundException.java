package com.zhmenko.primeaspecttask.model.exceptions;

public class CountriesNotFoundException extends RuntimeException {
    public CountriesNotFoundException() { super("Countries not found!");}
}
