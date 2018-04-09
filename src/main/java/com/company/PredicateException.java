package com.company;

public class PredicateException extends Exception {
    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }

    public PredicateException() {
        super();
    }

    public PredicateException(String message) {
        super(message);
    }
}
