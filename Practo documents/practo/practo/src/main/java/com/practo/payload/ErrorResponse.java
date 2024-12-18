package com.practo.payload;


import java.util.Date;

public class ErrorResponse {


    private String message;
    private int status;
    private Date timestamp;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public ErrorResponse(String message,int status, Date timestamp) {
        this.message = message;
        this.status = status;
        this.timestamp = timestamp;
    }
}