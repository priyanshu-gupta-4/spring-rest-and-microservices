package com.in28minutes.rest.webservices.restfulwebservices.beans;

public class HelloWorldBean {

    private final String message;
    public String getMessage() {
        return message;
    }

    public HelloWorldBean(String message) {
        this.message=message;
    }
}
