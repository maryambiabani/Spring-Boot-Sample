package com.example.demo.model.entity;

public class GetAverageOutput {
    private int errorCode;
    private String message;
    private float ave;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public float getAve() {
        return ave;
    }

    public void setAve(float ave) {
        this.ave = ave;
    }
}
