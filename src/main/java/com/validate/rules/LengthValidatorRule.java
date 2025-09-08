package com.validate.rules;

import com.validate.exception.PasswordValidationException;
import com.validate.password.PasswordValidatorRule;

public class LengthValidatorRule implements PasswordValidatorRule {
    @Override
    public void validate(String password) throws PasswordValidationException {
        if (password.length() <= 8) {
            throw new PasswordValidationException("Password should be larger than 8 char.");
        }

    }
}
