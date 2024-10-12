package com.reto.seek.demo.infraestructure.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Candidate request model")
public class CandidateRequest {

    @NotBlank(message = "name is required")
    @Size(max = 100, message = "name must be less than 100 characters")
    public String name;

    @NotBlank(message = "email is required")
    @Email(message = "email should be valid")
    @Size(max=100, message = "email must be less than 100 characters")
    public String email;

    @Size(max = 10, message = "Gender must be less than or equal to 10 characters")
    public String gender;

    @NotNull(message = "Expected salary is mandatory")
    @DecimalMin(value = "0.0", inclusive = false, message = "Expected salary must be greater than zero")
    @Digits(integer = 10, fraction = 2, message = "Expected salary must be a valid monetary amount")
    public String expectedSalary;
    @Size(max = 50, message = "Type of contract must be less than or equal to 50 characters")
    public String typeOfContract;
}
