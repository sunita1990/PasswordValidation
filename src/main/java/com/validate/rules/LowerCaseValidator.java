package com.validate.rules;

import com.validate.exception.PasswordValidationFailure;
import com.validate.password.PasswordValidator;

public class LowerCaseValidator implements PasswordValidator {

    @Override
    public void validate(String password) throws PasswordValidationFailure {
        if(!password.matches(".*[a-z].*")){
            throw new PasswordValidationFailure("Password should have one lowercase letter at least.");
        }
    }
}
