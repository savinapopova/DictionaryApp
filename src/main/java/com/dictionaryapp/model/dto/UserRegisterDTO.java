package com.dictionaryapp.model.dto;

import com.dictionaryapp.validation.annotation.PasswordMatch;
import com.dictionaryapp.validation.annotation.UniqueEmail;
import com.dictionaryapp.validation.annotation.UniqueUsername;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@PasswordMatch(first = "password", second = "confirmPassword")
public class UserRegisterDTO {

    @UniqueUsername
    @NotBlank(message = "Username cannot be empty!")
    @Size(min = 3, max = 20, message = "Username length must be between 3 and 20 characters!")
    private String username;

    @UniqueEmail
    @NotBlank(message = "Email cannot be empty!")
    @Email(message = "Enter valid email!")
    private String email;

    @NotBlank(message = "Password cannot be empty.")
    @Size(min = 3, max = 20, message = "Password length must be between 3 and 20 characters!")
    private String password;

    @NotBlank(message = "Password cannot be empty.")
    @Size(min = 3, max = 20, message = "Password length must be between 3 and 20 characters!")
    private String confirmPassword;

    public String getUsername() {
        return username;
    }

    public UserRegisterDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterDTO setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
