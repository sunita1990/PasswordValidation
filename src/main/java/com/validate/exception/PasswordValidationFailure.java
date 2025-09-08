package com.validate.exception;

public class PasswordValidationFailure extends Exception{

    public PasswordValidationFailure(String message){
        super(message);
    }
}
