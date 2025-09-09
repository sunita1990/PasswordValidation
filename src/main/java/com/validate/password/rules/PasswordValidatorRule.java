package com.validate.password.rules;

import com.validate.password.exception.PasswordValidationException;

public interface PasswordValidatorRule {

    void validate(String password) throws PasswordValidationException;

}
