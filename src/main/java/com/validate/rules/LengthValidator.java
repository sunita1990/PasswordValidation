package com.validate.rules;

import com.validate.exception.PasswordValidationFailure;
import com.validate.password.PasswordValidator;

public class LengthValidator implements PasswordValidator {
    @Override
    public void validate(String password) throws PasswordValidationFailure {
        if(password.length()<=8){
            throw new PasswordValidationFailure("Password should be larger than 8 char.");
        }

    }
}
