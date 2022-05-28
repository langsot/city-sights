package com.github.langsot.citysights.exception;

public class SightNotFoundException extends RuntimeException {
    public SightNotFoundException(String message) {
        super(message);
    }
}
