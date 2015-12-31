package com.cnc.exception;

/**
 * Created by Joe on 2015/12/31/0031.
 */
public class BasicException extends Exception {
    private String error;
    private String description;

    public BasicException(String error, String description) {
        this.error = error;
        this.description = description;
    }


    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
