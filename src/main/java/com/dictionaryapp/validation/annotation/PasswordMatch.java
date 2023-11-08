package com.dictionaryapp.validation.annotation;

import com.dictionaryapp.validation.PasswordMatchValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = PasswordMatchValidator.class)
public @interface PasswordMatch {
    String first();

    String second();

    String message() default "Passwords should match.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
