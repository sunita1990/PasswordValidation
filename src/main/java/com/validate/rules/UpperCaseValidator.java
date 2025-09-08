package com.validate.rules;

import ch.qos.logback.core.util.StringUtil;
import com.validate.exception.PasswordValidationFailure;
import com.validate.password.PasswordValidator;

public class UpperCaseValidator implements PasswordValidator {


    @Override
    public void validate(String password) throws PasswordValidationFailure {
        if(!password.matches(".*[A-Z].*")){
            throw new PasswordValidationFailure("Password should have one uppercase letter at least.");
        }
    }

}
