package com.stacksmplify.restservices.springbootbuildingblocks.exceptions;

import java.util.Date;

public class CustomErrorDetails {

    private Date timeStamp;
    private String errorDetails;
    private String message;

    public CustomErrorDetails(Date timeStamp, String errorDetails, String messsage) {
        this.timeStamp = timeStamp;
        this.errorDetails = errorDetails;
        this.message = messsage;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public String getErrorDetails() {
        return errorDetails;
    }

    public String getMessage() {
        return message;
    }
}
