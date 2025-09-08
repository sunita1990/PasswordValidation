package com.validate.PasswordValidation;

import com.validate.exception.PasswordValidationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PasswordValidationServiceTests {

    @Test
    void contextLoads() {
    }

    @Test()
    public void validatePasswordAllValidationSuccessTest() throws PasswordValidationException {
        Assertions.assertTrue(PasswordValidationService.validate("passwordA123"));
    }

    @Test()
    public void validatePasswordNullCheckFailureTest() throws PasswordValidationException {

        PasswordValidationException expectedException = new PasswordValidationException("Password cannot be Null or Empty.");
        PasswordValidationException resultException = Assertions.assertThrows(PasswordValidationException.class, () -> {
            PasswordValidationService.validate("");

        });
        Assertions.assertEquals(expectedException.getMessage(), resultException.getMessage());
    }

    @Test()
    public void validatePasswordNoLowercaseFailureTest() throws PasswordValidationException {

        PasswordValidationException expectedException = new PasswordValidationException("Password should have one lowercase letter at least.");
        PasswordValidationException resultException = Assertions.assertThrows(PasswordValidationException.class, () -> {
            PasswordValidationService.validate("PASSWORD!@");

        });
        Assertions.assertEquals(expectedException.getMessage(), resultException.getMessage());
    }

    @Test()
    public void atLeastOneConditionUpperCaseTrueTest() throws PasswordValidationException {
        Assertions.assertTrue(PasswordValidationService.validate("passA")); //password containing number
    }

    @Test()
    public void atLeastOneConditionNumberTrueTest() throws PasswordValidationException {
        Assertions.assertTrue(PasswordValidationService.validate("passw12")); //password containing number
    }

    @Test()
    public void atLeastOneConditionLengthTrueTest() throws PasswordValidationException {
        Assertions.assertTrue(PasswordValidationService.validate("password@!")); //password containing number
    }

    @Test()
    public void atLeastOneConditionUpperCaseLengthTest() throws PasswordValidationException {
        Assertions.assertTrue(PasswordValidationService.validate("pass123")); //password containing number
    }

    @Test()
    public void atLeastOneConditionNumberLengthValidationSuccessTest() throws PasswordValidationException {
        Assertions.assertTrue(PasswordValidationService.validate("passA"));//password containing Uppercase
    }

    @Test()
    public void atLeastOneConditionNumberUpperCaseValidationSuccessTest() throws PasswordValidationException {
        Assertions.assertTrue(PasswordValidationService.validate("password@a"));// password length more than 8
    }

    @Test()
    public void atLeastOneConditionFailureTest() throws PasswordValidationException {
        Assertions.assertFalse(PasswordValidationService.validate("pass"));// password length more than 8
    }

}
