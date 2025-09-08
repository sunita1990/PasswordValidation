package com.validate.password.service;

import com.validate.password.exception.PasswordValidationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PasswordValidationServiceTests {

    @Test
    void contextLoads() {
    }

    @Test()
    public void validatePasswordValidationSuccessTest() throws PasswordValidationException {
        Assertions.assertTrue(PasswordValidationService.validate("passwordA123"));
    }

    @Test()
    public void passwordIsNullFailureTest() throws PasswordValidationException {

        PasswordValidationException expectedException = new PasswordValidationException("Password cannot be Null or Empty.");
        PasswordValidationException resultException = Assertions.assertThrows(PasswordValidationException.class, () -> {
            PasswordValidationService.validate("");

        });
        Assertions.assertEquals(expectedException.getMessage(), resultException.getMessage());
    }

    @Test()
    public void passwordNoLowercaseFailureTest() throws PasswordValidationException {

        PasswordValidationException expectedException = new PasswordValidationException("Password should have one lowercase letter at least.");
        PasswordValidationException resultException = Assertions.assertThrows(PasswordValidationException.class, () -> {
            PasswordValidationService.validate("PASSWORD!@");

        });
        Assertions.assertEquals(expectedException.getMessage(), resultException.getMessage());
    }

    @Test()
    public void passwordLengthAndNumberFalseTest() throws PasswordValidationException {
        Assertions.assertTrue(PasswordValidationService.validate("passA"));
    }

    @Test()
    public void passwordLengthAndUpperCaseFalseTest() throws PasswordValidationException {
        Assertions.assertTrue(PasswordValidationService.validate("pass12"));
    }

    @Test()
    public void passwordNumberAndUpperCaseFalseTest() throws PasswordValidationException {
        Assertions.assertTrue(PasswordValidationService.validate("validator@!"));
    }

    @Test()
    public void passwordUpperCaseFalseTest() throws PasswordValidationException {
        Assertions.assertTrue(PasswordValidationService.validate("validator@12"));
    }

    @Test()
    public void passwordNumberFalseTest() throws PasswordValidationException {
        Assertions.assertTrue(PasswordValidationService.validate("validator@A!"));
    }

    @Test()
    public void passwordLengthFalseTest() throws PasswordValidationException {
        Assertions.assertTrue(PasswordValidationService.validate("passA12"));
    }

    @Test()
    public void atLeastOneConditionFailureTest() throws PasswordValidationException {
        Assertions.assertFalse(PasswordValidationService.validate("pass"));
    }

}
