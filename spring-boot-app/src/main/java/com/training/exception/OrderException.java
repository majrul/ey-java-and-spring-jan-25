package com.training.exception;

public class OrderException extends RuntimeException {

    public OrderException() {
    }

    public OrderException(String message, Throwable cause) {
        super(message, cause);
    }

    public OrderException(String message) {
        super(message);
    }
}
