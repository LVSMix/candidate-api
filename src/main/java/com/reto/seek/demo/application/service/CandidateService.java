package com.reto.seek.demo.application.service;

import com.reto.seek.demo.infraestructure.request.CandidateRequest;
import com.reto.seek.demo.infraestructure.response.CandidateResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CandidateService {
    List<CandidateResponse> getCandidates();

    CandidateResponse createCandidate(CandidateRequest candidateRequest);

    CandidateResponse updateCandidate(CandidateRequest candidateRequest, Long id);

    void deleteCandidate(@Parameter(description = "ID of the candidate to be deleted")Long id);
    CandidateResponse getCandidate(Long id);
}
