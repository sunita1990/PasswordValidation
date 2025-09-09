package com.validate.password.rules;

import com.validate.password.exception.PasswordValidationException;

public class LengthValidator implements PasswordValidatorRule {
    @Override
    public void validate(String password) throws PasswordValidationException {
        if (password.length() <= 8) {
            throw new PasswordValidationException("Password should be larger than 8 char.");
        }

    }
}
