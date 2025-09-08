package com.validate.rules;

import com.validate.exception.PasswordValidationException;
import com.validate.password.PasswordValidatorRule;

public class UpperCaseValidatorRule implements PasswordValidatorRule {

    public final String ONE_UPPER_CASE_REGEX = ".*[A-Z].*";

    @Override
    public void validate(String password) throws PasswordValidationException {
        if (!password.matches(ONE_UPPER_CASE_REGEX)) {
            throw new PasswordValidationException("Password should have one uppercase letter at least.");
        }
    }

}
