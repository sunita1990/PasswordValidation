package com.validate.PasswordValidation;

import com.validate.exception.PasswordValidationException;
import com.validate.password.PasswordValidatorRule;
import com.validate.rules.*;

import java.util.Arrays;
import java.util.List;

public class PasswordValidationService {

    public static void main(String[] args) throws PasswordValidationException {
        validate("password");

    }

    public static boolean validate(String password) throws PasswordValidationException {

        List<PasswordValidatorRule> atLeastOneRules = Arrays.asList(new LengthValidatorRule(), new UpperCaseValidatorRule(), new NumberValidatorRule());
        List<PasswordValidatorRule> mandatoryRules = Arrays.asList(new NullOrEmptyValidatorRule(), new LowerCaseValidatorRule());

        //3 point of problem
        for (PasswordValidatorRule validator : mandatoryRules) {
            validator.validate(password);
        }

        //2 point of problem
        int count = 0;
        for (PasswordValidatorRule validator : atLeastOneRules) {
            try {
                validator.validate(password);
                count++;
            } catch (PasswordValidationException e) {
                System.out.println("in exception");
            }
        }
        return count >= 1;
    }

}
