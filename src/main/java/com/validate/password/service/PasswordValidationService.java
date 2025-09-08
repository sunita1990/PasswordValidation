package com.validate.password.service;

import com.validate.password.exception.PasswordValidationException;
import com.validate.password.validator.PasswordValidatorRule;
import com.validate.password.rules.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;


public class PasswordValidationService {
    private static final Logger log = LoggerFactory.getLogger(PasswordValidationService.class);
    public static void main(String[] args) throws PasswordValidationException {
        validate("validator");

    }

    public static boolean validate(String password) throws PasswordValidationException {
        //List for checking atLeast one validation
        List<PasswordValidatorRule> atLeastOneRules = Arrays.asList(new LengthValidator(), new ContainsUpperCaseValidator(), new ContainsNumberValidator());

        //List for checking atLeast mandatory validation
        List<PasswordValidatorRule> mandatoryRules = Arrays.asList(new NullOrEmptyValidator(), new ContainsLowerCaseValidator());

        for (PasswordValidatorRule validator : mandatoryRules) {
            validator.validate(password);
        }

        int count = 0;
        for (PasswordValidatorRule validator : atLeastOneRules) {
            try {
                validator.validate(password);
                count++;
            } catch (PasswordValidationException e) {
                log.info("in exception");
            }
        }
        return count >= 1;
    }

}
