package com.validate.rules;

import ch.qos.logback.core.util.StringUtil;
import com.validate.exception.PasswordValidationException;
import com.validate.password.PasswordValidatorRule;

public class NullOrEmptyValidatorRule implements PasswordValidatorRule {


    @Override
    public void validate(String password) throws PasswordValidationException {

        if (StringUtil.isNullOrEmpty(password)) {
            throw new PasswordValidationException("Password cannot be Null or Empty.");
        }

    }


}
