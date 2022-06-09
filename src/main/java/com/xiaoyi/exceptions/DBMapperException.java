package com.xiaoyi.exceptions;

public class DBMapperException extends RuntimeException {
    public DBMapperException(final String message) {super(message);}

    public DBMapperException(final String message, final Exception e) {super(message, e);}

}
