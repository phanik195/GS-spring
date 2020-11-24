package com.example.employee.dto;

import java.time.LocalDateTime;

public class ErrorDto {

    //Reason to failed
    private String reason;

    //Field name
    private String fieldName;

    //Field value
    private String fieldValue;

    //failed time
    private LocalDateTime timeOfFailure = LocalDateTime.now();

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }

    public LocalDateTime getTimeOfFailure() {
        return timeOfFailure;
    }

    public void setTimeOfFailure(LocalDateTime timeOfFailure) {
        this.timeOfFailure = timeOfFailure;
    }
}
