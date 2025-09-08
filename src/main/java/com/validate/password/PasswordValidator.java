package com.validate.password;

import com.validate.exception.PasswordValidationFailure;

public interface PasswordValidator {

    void validate(String password) throws PasswordValidationFailure;

}
