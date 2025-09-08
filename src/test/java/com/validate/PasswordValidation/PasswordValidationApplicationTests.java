package com.validate.PasswordValidation;

import com.validate.exception.PasswordValidationFailure;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class PasswordValidationApplicationTests {


	@Test
	void contextLoads() {
	}

    @Test()
    public void validatePasswordNullTest() {
        Assertions.assertThrows(PasswordValidationFailure.class,()->{
            PasswordValidationApplication.validate("");
        });
    }

   /* @Test()
    public void validatePasswordCharacterLengthTest() {
        Assertions.assertThrows(PasswordValidationFailure.class,()->{
            PasswordValidationApplication.validate("pass");
        });
    }*/

   /* @Test()
    public void validatePasswordUppercaseTest() {
        Assertions.assertThrows(PasswordValidationFailure.class,()->{
            PasswordValidationApplication.validate("password12");
        });
    }*/

    @Test()
    public void validatePasswordLowercaseTest() {
        Assertions.assertThrows(PasswordValidationFailure.class,()->{
            PasswordValidationApplication.validate("PASSWORD!@");
        });
    }

    /*@Test()
    public void validatePasswordNumberTest()  {
        Assertions.assertThrows(PasswordValidationFailure.class,()->{
            PasswordValidationApplication.validate("passwordA");
        });
    }*/


    @Test()
    public void validatePasswordSuccessTest() throws PasswordValidationFailure {
        Assertions.assertTrue(PasswordValidationApplication.validate("passwordA123"));
    }

}
