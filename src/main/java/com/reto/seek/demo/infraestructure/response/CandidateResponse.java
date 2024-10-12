package com.reto.seek.demo.infraestructure.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(description = "Candidate response model")
public class CandidateResponse {

    public String name;

    public String email;

    public String gender;

    public String expectedSalary;

    public String typeOfContract;
}
