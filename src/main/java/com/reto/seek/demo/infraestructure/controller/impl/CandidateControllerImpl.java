package com.reto.seek.demo.infraestructure.controller.impl;

import com.reto.seek.demo.application.service.CandidateService;
import com.reto.seek.demo.infraestructure.controller.CandidateController;
import com.reto.seek.demo.infraestructure.request.CandidateRequest;
import com.reto.seek.demo.infraestructure.response.CandidateResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/candidate")
@AllArgsConstructor
@Slf4j
public class CandidateControllerImpl implements CandidateController {

    private final CandidateService candidateService;


    @Override
    @GetMapping
    public ResponseEntity<List<CandidateResponse>> getCandidates() {
        List<CandidateResponse> result = candidateService.getCandidates();
        return ResponseEntity.ok(result);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<CandidateResponse> getCandidate(@PathVariable("id")Long id) {
        CandidateResponse response = candidateService.getCandidate(id);
        return ResponseEntity.ok(response);
    }

    @Override
    @PostMapping
    public ResponseEntity<CandidateResponse> createCandidate(@RequestBody CandidateRequest candidateRequest) {
        CandidateResponse response = candidateService.createCandidate(candidateRequest);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CandidateResponse> updateCandidate(@Valid @RequestBody CandidateRequest candidateRequest, @PathVariable("id") Long id) {
        CandidateResponse response =  candidateService.updateCandidate(candidateRequest, id);
        return ResponseEntity.ok(response);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCandidate(@PathVariable("id")Long id) {
        candidateService.deleteCandidate(id);
        return ResponseEntity.noContent().build();
    }
}
