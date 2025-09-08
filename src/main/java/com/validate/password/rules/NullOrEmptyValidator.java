package com.validate.password.rules;

import ch.qos.logback.core.util.StringUtil;
import com.validate.password.exception.PasswordValidationException;
import com.validate.password.validator.PasswordValidatorRule;

public class NullOrEmptyValidator implements PasswordValidatorRule {


    @Override
    public void validate(String password) throws PasswordValidationException {

        if (StringUtil.isNullOrEmpty(password)) {
            throw new PasswordValidationException("Password cannot be Null or Empty.");
        }

    }


}
