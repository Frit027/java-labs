package com.mirea;

public class OrderAlreadyAddedException extends Exception {

    public OrderAlreadyAddedException(String message) {
        super(message);
    }
}
