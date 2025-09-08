package com.validate.PasswordValidation;

import com.validate.exception.PasswordValidationFailure;
import com.validate.password.PasswordValidator;
import com.validate.rules.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Clock;
import java.util.Arrays;
import java.util.List;

public class PasswordValidationApplication {

	public static void main(String[] args) throws PasswordValidationFailure {
    validate("password");

    }


    public static boolean validate(String password) throws PasswordValidationFailure {

        List<PasswordValidator> anyValidatorList= Arrays.asList(new LengthValidator(), new UpperCaseValidator(), new NumberValidator());
        List<PasswordValidator> mandatoryValidatorList= Arrays.asList(new NullValidator(), new LowerCaseValidator());

        //3 point of problem
        for(PasswordValidator validator:mandatoryValidatorList){
            validator.validate(password);
        }

        //2 point of problem
        int count=0;
        for(PasswordValidator validator:anyValidatorList){
            try{
                validator.validate(password);
                count++;
            }catch(PasswordValidationFailure e){
                System.out.println("in exception");
            }
        }
        return count >= 3;
    }
    
}
