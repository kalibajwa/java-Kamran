package com.demoapp.assignment.exception;

public class CounterNotFoundException extends RuntimeException {
    public CounterNotFoundException() {
    }

    public CounterNotFoundException(String message) {
        super(message);
    }
}
