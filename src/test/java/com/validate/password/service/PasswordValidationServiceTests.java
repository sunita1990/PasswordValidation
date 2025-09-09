package com.validate.password.service;

import com.validate.password.exception.PasswordValidationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PasswordValidationServiceTests {

    private PasswordValidationService passwordValidationService;

    @BeforeEach
    void setUp(){
        passwordValidationService = new PasswordValidationService();
    }

    @Test
    void contextLoads() {
    }

    @Test()
    public void validatePasswordValidationSuccessTest() throws PasswordValidationException {
        Assertions.assertTrue(passwordValidationService.validate("passwordA123"));
    }

    @Test()
    public void passwordIsNullFailureTest() throws PasswordValidationException {
        PasswordValidationException resultException = Assertions.assertThrows(PasswordValidationException.class, () -> {
            passwordValidationService.validate("");

        });
        assertThat("Password cannot be Null or Empty.").isEqualTo(resultException.getMessage());
    }

    @Test()
    public void passwordNoLowercaseFailureTest() throws PasswordValidationException {

        PasswordValidationException resultException = Assertions.assertThrows(PasswordValidationException.class, () -> {
            passwordValidationService.validate("PASSWORD!@");

        });

        assertThat("Password should have one lowercase letter at least.").isEqualTo(resultException.getMessage());
    }

    @Test()
    public void passwordLengthAndNumberFalseTest() throws PasswordValidationException {
        Assertions.assertTrue(passwordValidationService.validate("passA"));
    }

    @Test()
    public void passwordLengthAndUpperCaseFalseTest() throws PasswordValidationException {
        Assertions.assertTrue(passwordValidationService.validate("pass12"));
    }

    @Test()
    public void passwordNumberAndUpperCaseFalseTest() throws PasswordValidationException {
        Assertions.assertTrue(passwordValidationService.validate("validator@!"));
    }

    @Test()
    public void passwordUpperCaseFalseTest() throws PasswordValidationException {
        Assertions.assertTrue(passwordValidationService.validate("validator@12"));
    }

    @Test()
    public void passwordNumberFalseTest() throws PasswordValidationException {
        Assertions.assertTrue(passwordValidationService.validate("validator@A!"));
    }

    @Test()
    public void passwordLengthFalseTest() throws PasswordValidationException {
        Assertions.assertTrue(passwordValidationService.validate("passA12"));
    }

    @Test()
    public void atLeastOneConditionFailureTest() throws PasswordValidationException {
        Assertions.assertFalse(passwordValidationService.validate("pass"));
    }

}
