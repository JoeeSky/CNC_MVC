package com.cnc.exception;

/**
 * Created by Joe on 2015/12/31/0031.
 */
public class BadRequestException extends BasicException{

    public BadRequestException(String error, String description) {
        super(error, description);
    }
}
