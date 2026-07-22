package com.pizza.sesamo.service.exception;

public class EmailApiException extends RuntimeException{

    public EmailApiException() {
        super("Error sending email");
    }
}
