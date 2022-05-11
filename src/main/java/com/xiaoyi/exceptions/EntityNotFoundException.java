package com.xiaoyi.exceptions;

public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(final String message) {super(message);}

    public EntityNotFoundException(final String message, final Exception e) {super(message, e);}
}
