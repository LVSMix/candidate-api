package com.reto.seek.demo.application.service;

import com.reto.seek.demo.application.service.impl.CandidateServiceImpl;
import com.reto.seek.demo.domain.model.Candidate;
import com.reto.seek.demo.infraestructure.mapper.CandidateMapper;
import com.reto.seek.demo.infraestructure.repository.CandidateRepository;
import com.reto.seek.demo.infraestructure.request.CandidateRequest;
import com.reto.seek.demo.infraestructure.response.CandidateResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CandidateServiceImplTest {

    @Mock
    private CandidateRepository candidateRepository;

    @InjectMocks
    private CandidateServiceImpl candidateService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetCandidates() {
        Candidate candidate = new Candidate();
        candidate.setName("John Doe");
        candidate.setEmail("john.doe@example.com");
        candidate.setGender("Male");
        candidate.setExpectedSalary(new BigDecimal("50000"));
        candidate.setTypeOfContract("Full-time");
        when(candidateRepository.findAll()).thenReturn(Arrays.asList(candidate));

        List<CandidateResponse> candidates = candidateService.getCandidates();

        assertNotNull(candidates);
        assertEquals(1, candidates.size());
        verify(candidateRepository, times(1)).findAll();
    }

    @Test
    void testCreateCandidate() {
        CandidateRequest request = new CandidateRequest();
        request.setName("John Doe");
        request.setEmail("john.doe@example.com");
        request.setGender("Male");
        request.setExpectedSalary("50000");
        request.setTypeOfContract("Full-time");
        Candidate candidate = new Candidate();
        candidate.setName("John Doe");
        candidate.setEmail("john.doe@example.com");
        candidate.setGender("Male");
        candidate.setExpectedSalary(new BigDecimal("50000"));
        candidate.setTypeOfContract("Full-time");
        when(candidateRepository.save(any(Candidate.class))).thenReturn(candidate);

        CandidateResponse response = candidateService.createCandidate(request);

        assertNotNull(response);
        verify(candidateRepository, times(1)).save(any(Candidate.class));
    }

    @Test
    void testUpdateCandidate() {
        Long id = 1L;
        CandidateRequest request = new CandidateRequest();
        request.setName("John Doe");
        request.setEmail("john.doe@example.com");
        request.setGender("Male");
        request.setExpectedSalary("50000");
        request.setTypeOfContract("Full-time");

        Candidate candidate = new Candidate();
        when(candidateRepository.findById(id)).thenReturn(Optional.of(candidate));
        when(candidateRepository.save(any(Candidate.class))).thenReturn(candidate);

        CandidateResponse response = candidateService.updateCandidate(request, id);

        assertNotNull(response);
        assertEquals("John Doe", candidate.getName());
        verify(candidateRepository, times(1)).findById(id);
        verify(candidateRepository, times(1)).save(candidate);
    }

    @Test
    void testDeleteCandidate() {
        Long id = 1L;

        doNothing().when(candidateRepository).deleteById(id);

        candidateService.deleteCandidate(id);

        verify(candidateRepository, times(1)).deleteById(id);
    }

    @Test
    void testGetCandidate() {
        Long id = 1L;
        Candidate candidate = new Candidate();
        candidate.setName("John Doe");
        candidate.setEmail("john.doe@example.com");
        candidate.setGender("Male");
        candidate.setExpectedSalary(new BigDecimal("50000"));
        candidate.setTypeOfContract("Full-time");
        when(candidateRepository.findById(id)).thenReturn(Optional.of(candidate));

        CandidateResponse response = candidateService.getCandidate(id);

        assertNotNull(response);
        verify(candidateRepository, times(1)).findById(id);
    }
}
