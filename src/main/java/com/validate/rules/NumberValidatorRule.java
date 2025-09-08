package com.validate.rules;

import com.validate.exception.PasswordValidationException;
import com.validate.password.PasswordValidatorRule;

public class NumberValidatorRule implements PasswordValidatorRule {
    public final String ONE_NUMBER_REGEX = ".*[0-9].*";

    @Override
    public void validate(String password) throws PasswordValidationException {
        if (!password.matches(ONE_NUMBER_REGEX)) {
            throw new PasswordValidationException("Password should have one number at least.");
        }
    }
}
