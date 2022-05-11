package com.xiaoyi.exceptions;

public class NegativeBalanceException extends RuntimeException{

    public NegativeBalanceException(final String message) {super(message);}

    public NegativeBalanceException(final String message, final Exception e) {super(message, e);}
}
