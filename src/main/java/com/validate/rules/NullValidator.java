package com.validate.rules;

import ch.qos.logback.core.util.StringUtil;
import com.validate.exception.PasswordValidationFailure;
import com.validate.password.PasswordValidator;
import org.springframework.util.StringUtils;

public class NullValidator implements PasswordValidator {


    @Override
    public void validate(String password) throws PasswordValidationFailure {
        if(StringUtil.isNullOrEmpty(password)){
            throw new PasswordValidationFailure("Password cannot be Null");
        }

    }


}
