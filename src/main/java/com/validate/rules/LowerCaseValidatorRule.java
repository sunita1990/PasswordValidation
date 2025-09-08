package com.validate.rules;

import com.validate.exception.PasswordValidationException;
import com.validate.password.PasswordValidatorRule;

public class LowerCaseValidatorRule implements PasswordValidatorRule {
    public final String ONE_LOWER_CASE_REGEX = ".*[a-z].*";

    @Override
    public void validate(String password) throws PasswordValidationException {
        if (!password.matches(ONE_LOWER_CASE_REGEX)) {
            throw new PasswordValidationException("Password should have one lowercase letter at least.");
        }
    }
}
