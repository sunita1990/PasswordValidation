package com.validate.password.service;

import com.validate.password.exception.PasswordValidationException;
import com.validate.password.rules.PasswordValidatorRule;
import com.validate.password.rules.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class PasswordValidationService {
    private static final Logger log = LoggerFactory.getLogger(PasswordValidationService.class);

    private final List<PasswordValidatorRule> atLeastOneRules ; //List for checking atLeast one validation
    private final List<PasswordValidatorRule> mandatoryRules ; //List for checking atLeast mandatory validation

    public PasswordValidationService() {

        this.atLeastOneRules = Arrays.asList(new LengthValidator(), new ContainsUpperCaseValidator(), new ContainsNumberValidator());
        this.mandatoryRules = Arrays.asList(new NullOrEmptyValidator(), new ContainsLowerCaseValidator());
    }

    public static void main(String[] args) throws PasswordValidationException {
        PasswordValidationService PasswordValidationService =new PasswordValidationService();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the password");
        String inputPassword= scanner.nextLine();
        System.out.println("Input Password is::, "+ inputPassword);
        boolean validationResult = PasswordValidationService.validate(inputPassword);
        log.info("Password Validation is successful or not::{}",validationResult);

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
                log.error("in catch exception::{}", e.getMessage());
            }
        }
        return count >= 1;
    }

}
