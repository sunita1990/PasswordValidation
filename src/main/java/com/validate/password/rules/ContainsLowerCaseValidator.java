package com.validate.password.rules;

import com.validate.password.exception.PasswordValidationException;

public class ContainsLowerCaseValidator implements PasswordValidatorRule {
    public final String ONE_LOWER_CASE_REGEX = ".*[a-z].*";

    @Override
    public void validate(String password) throws PasswordValidationException {
        if (!password.matches(ONE_LOWER_CASE_REGEX)) {
            throw new PasswordValidationException("Password should have one lowercase letter at least.");
        }
    }
}
