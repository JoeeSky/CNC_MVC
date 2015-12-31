package com.cnc.exception;

/**
 * Created by Joe on 2015/12/31/0031.
 */
public class NotFoundException extends BasicException {
    public NotFoundException(String error, String description) {
        super(error, description);
    }
}
