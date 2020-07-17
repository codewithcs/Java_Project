package com.murex.retail.experience;

public class InvalidCategoryException extends RuntimeException {

    public InvalidCategoryException(String message) {
        super(message);
    }

    public InvalidCategoryException() {

    }
}
