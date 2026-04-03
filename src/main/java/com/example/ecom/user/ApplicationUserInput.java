package com.example.ecom.user;

import jakarta.validation.constraints.*;

public record ApplicationUserInput(

        @NotBlank(message = "Username is required")
        String userName,

        @Email(message = "Invalid email format")
        @NotBlank(message = "Email is required")
        String email,

        @NotBlank(message = "Password is required")
        @Size(min = 6, message = "Password must be at least 6 characters")
        String password,

        @NotBlank(message = "User type is required")
        String userType
) {}
