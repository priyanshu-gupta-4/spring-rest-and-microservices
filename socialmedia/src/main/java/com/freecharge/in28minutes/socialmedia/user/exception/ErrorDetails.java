package com.freecharge.in28minutes.socialmedia.user.exception;

import java.time.LocalDate;

public class ErrorDetails {
    private LocalDate timestamp;
    private String message;
    private String Details;

    public ErrorDetails(LocalDate timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        Details = details;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return Details;
    }
}
