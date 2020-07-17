package com.murex.retail.experience;

public class DatabaseReadException extends RuntimeException{

    public DatabaseReadException(String message) {
        super(message);
    }

public DatabaseReadException(String s, Exception e){
        super(s, e);
}
}
