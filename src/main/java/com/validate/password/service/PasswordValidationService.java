package com.validate.password.service;

import com.validate.password.exception.PasswordValidationException;
import com.validate.password.rules.PasswordValidatorRule;
import com.validate.password.rules.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;


public class PasswordValidationService {
    private  final Logger log = LoggerFactory.getLogger(PasswordValidationService.class);

    private final List<PasswordValidatorRule> atLeastOneRules ; //List for checking atLeast one validation
    private final List<PasswordValidatorRule> mandatoryRules ; //List for checking atLeast mandatory validation

    public PasswordValidationService() {

        this.atLeastOneRules = Arrays.asList(new LengthValidator(), new ContainsUpperCaseValidator(), new ContainsNumberValidator());
        this.mandatoryRules = Arrays.asList(new NullOrEmptyValidator(), new ContainsLowerCaseValidator());
    }

    public static void main(String[] args) throws PasswordValidationException {
        PasswordValidationService PasswordValidationService =new PasswordValidationService();
        PasswordValidationService.validate("validator");

    }

    public boolean validate(String password) throws PasswordValidationException {

        for (PasswordValidatorRule validator : mandatoryRules) {
            validator.validate(password);
        }

        int count = 0;
        for (PasswordValidatorRule validator : atLeastOneRules) {
            try {
                validator.validate(password);
                count++;
            } catch (PasswordValidationException e) {
                log.error("in exception");
            }
        }
        return count >= 1;
    }

}
