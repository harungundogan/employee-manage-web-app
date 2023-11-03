package com.springboot.thymeleaf.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy=EmailConstraintsValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Email {

    public String value() default ".com";

    public String message() default "invalid email format";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};

}
