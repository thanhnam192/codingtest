package com.announcingsystem.lambda;

public class HandlerRequest {
    private String message;

    public HandlerRequest(){}

    public HandlerRequest(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
