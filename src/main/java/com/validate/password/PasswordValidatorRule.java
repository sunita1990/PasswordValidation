package com.validate.password;

import com.validate.exception.PasswordValidationException;

public interface PasswordValidatorRule {

    void validate(String password) throws PasswordValidationException;

}
