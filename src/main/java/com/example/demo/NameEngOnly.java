package com.example.demo;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NameEngOnly.NameEngValidator.class)
public @interface NameEngOnly {

    String message() default "{}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class NameEngValidator implements ConstraintValidator<NameEngOnly, String> {

        @Override
        public boolean isValid(String value, ConstraintValidatorContext context) {
            return value.matches("[a-zA-Z. ]+$");
        }
    }

}
