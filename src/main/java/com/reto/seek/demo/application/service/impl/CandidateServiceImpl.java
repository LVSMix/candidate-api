package com.reto.seek.demo.application.service.impl;

import com.reto.seek.demo.application.service.CandidateService;
import com.reto.seek.demo.domain.model.Candidate;
import com.reto.seek.demo.infraestructure.mapper.CandidateMapper;
import com.reto.seek.demo.infraestructure.repository.CandidateRepository;
import com.reto.seek.demo.infraestructure.request.CandidateRequest;
import com.reto.seek.demo.infraestructure.response.CandidateResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class CandidateServiceImpl implements CandidateService {

    private  final CandidateRepository candidateRepository;
    @Override
    public List<CandidateResponse> getCandidates() {
        return candidateRepository.findAll()
                                  .stream()
                                  .map(CandidateMapper::toResponse)
                                  .collect(Collectors.toList());
    }

    @Override
    public CandidateResponse createCandidate(CandidateRequest candidateRequest) {
        return CandidateMapper.toResponse(
                candidateRepository.save(CandidateMapper.toEntity(candidateRequest))
        );
    }

    @Override
    public CandidateResponse updateCandidate(CandidateRequest candidateRequest, Long id) {
        Candidate candidate = this.candidateRepository.findById(id).orElse(null);
        if (Objects.isNull(candidate)) {
            throw new RuntimeException("Candidate not found with id: " + id);
        }
        candidate.setName(candidateRequest.getName());
        candidate.setEmail(candidateRequest.getEmail());
        candidate.setGender(candidateRequest.getGender());
        candidate.setExpectedSalary(new BigDecimal(candidateRequest.getExpectedSalary()));
        candidate.setActive(true);
        candidate.setTypeOfContract(candidateRequest.getTypeOfContract());
        return CandidateMapper.toResponse(this.candidateRepository.save(candidate));
    }

    @Override
    public void deleteCandidate(Long id) {
        this.candidateRepository.deleteById(id);
    }

    @Override
    public CandidateResponse getCandidate(Long id) {
        Candidate candidate = this.candidateRepository.findById(id).orElse(null);
        if (Objects.isNull(candidate)) {
            throw new RuntimeException("Candidate not found with id: " + id);
        }
        return CandidateMapper.toResponse(candidate);
    }
}
