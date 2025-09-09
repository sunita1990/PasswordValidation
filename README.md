# Password Validator

This code is build for the purpose of password validation.

# Validation Rules

## AtLeastOne - Password is Ok at least
Password is greater than 8 
Password contains one uppercase at least
Password contains one number at least

## Mandatory Rule
Password is Not Null 
Password contains at least one lowercase

# Components

## Exception
For handling user defined exception for rules.

## Rules
* **PasswordValidatorRule** - It is an interface contains validate method which is implemented by all rules classes.
* **NullOrEmptyValidator** - File for validating if password is not null or blank.
* **LengthValidator** - file for validating if password is larger than 8 or not.
* **ContainsUpperCaseValidator** - file for validating if password has atl east one upper case.
* **ContainsLowerCaseValidator** - file for validating if password has at least one lower case
* **ContainsNumberValidator** - file for validating if password contains at least one number.

## Service
contains method validate the password Validation Rules.

