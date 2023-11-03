package com.springboot.thymeleaf.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailConstraintsValidator implements ConstraintValidator<Email,String> {

    private String emailSuffix;

    @Override
    public void initialize(Email theEmail) {
       emailSuffix = theEmail.value();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        boolean result;
        if (s != null) {
            result = s.endsWith(emailSuffix);
        }
        else{
            result = true;
        }
        return result;
    }

}
