package com.team7.rupiapp.dto.auth.signup;

import com.team7.rupiapp.dto.validation.ValidUnique;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SignupDto {
    @NotBlank(message = "Full name is required")
    private String fullName;

    @NotBlank(message = "Username is required")
    @ValidUnique(column = "username", message = "Username already been taken")
    private String username;

    @Email(message = "email must be a valid email")
    @NotBlank(message = "Email is required")
    @ValidUnique(column = "email", message = "Email already been taken")
    private String email;

    @NotBlank(message = "Phone is required")
    @ValidUnique(column = "phone", message = "Phone already been taken")
    private String phone;

    private String password;

    private String confirmPassword;
}
