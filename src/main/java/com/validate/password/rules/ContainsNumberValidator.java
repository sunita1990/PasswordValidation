package com.validate.password.rules;

import com.validate.password.exception.PasswordValidationException;
import com.validate.password.validator.PasswordValidatorRule;

public class ContainsNumberValidator implements PasswordValidatorRule {
    public final String ONE_NUMBER_REGEX = ".*[0-9].*";

    @Override
    public void validate(String password) throws PasswordValidationException {
        if (!password.matches(ONE_NUMBER_REGEX)) {
            throw new PasswordValidationException("Password should have one number at least.");
        }
    }
}
