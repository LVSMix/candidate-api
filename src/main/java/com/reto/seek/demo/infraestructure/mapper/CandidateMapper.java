package com.reto.seek.demo.infraestructure.mapper;

import com.reto.seek.demo.domain.model.Candidate;
import com.reto.seek.demo.infraestructure.request.CandidateRequest;
import com.reto.seek.demo.infraestructure.response.CandidateResponse;

import java.math.BigDecimal;

public class CandidateMapper {
    public static Candidate toEntity(CandidateRequest request) {
        Candidate candidate = new Candidate();
        candidate.setName(request.getName());
        candidate.setEmail(request.getEmail());
        candidate.setGender(request.getGender());
        candidate.setExpectedSalary(new BigDecimal(request.getExpectedSalary()));
        candidate.setTypeOfContract(request.getTypeOfContract());
        return candidate;
    }

    public static CandidateResponse toResponse(Candidate candidate) {
        return new CandidateResponse(
                candidate.getName(),
                candidate.getEmail(),
                candidate.getGender(),
                candidate.getExpectedSalary().toString(),
                candidate.getTypeOfContract()
        );
    }
}
