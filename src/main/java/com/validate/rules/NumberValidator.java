package com.validate.rules;

import com.validate.exception.PasswordValidationFailure;
import com.validate.password.PasswordValidator;

public class NumberValidator implements PasswordValidator {
    @Override
    public void validate(String password) throws PasswordValidationFailure {
        if(!password.matches(".*[1-9].*")){
            throw new PasswordValidationFailure("Password should have one number at least.");
        }
    }
}
