package com.dictionaryapp.validation;

import com.dictionaryapp.repo.UserRepository;
import com.dictionaryapp.validation.annotation.UniqueUsername;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.annotation.Annotation;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    private UserRepository userRepository;

    public UniqueUsernameValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return this.userRepository.findByUsername(value).isEmpty();
    }
}
