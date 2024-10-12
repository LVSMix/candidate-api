package com.reto.seek.demo.infraestructure.mapper;

import com.reto.seek.demo.domain.model.Candidate;
import com.reto.seek.demo.infraestructure.request.CandidateRequest;
import com.reto.seek.demo.infraestructure.response.CandidateResponse;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CandidateMapperTest {

    @Test
    public void testToEntity() {
        // Crear un objeto de prueba CandidateRequest
        CandidateRequest request = new CandidateRequest();
        request.setName("John Doe");
        request.setEmail("johndoe@example.com");
        request.setGender("Male");
        request.setExpectedSalary("50000.00");
        request.setTypeOfContract("Full-Time");

        // Mapear el request a entity
        Candidate candidate = CandidateMapper.toEntity(request);

        // Verificar que los valores son correctos
        assertEquals("John Doe", candidate.getName());
        assertEquals("johndoe@example.com", candidate.getEmail());
        assertEquals("Male", candidate.getGender());
        assertEquals(new BigDecimal("50000.00"), candidate.getExpectedSalary());
        assertEquals("Full-Time", candidate.getTypeOfContract());
    }

    @Test
    public void testToResponse() {
        // Crear un objeto de prueba Candidate
        Candidate candidate = new Candidate();
        candidate.setName("Jane Doe");
        candidate.setEmail("janedoe@example.com");
        candidate.setGender("Female");
        candidate.setExpectedSalary(new BigDecimal("60000.00"));
        candidate.setTypeOfContract("Part-Time");

        // Mapear el entity a response
        CandidateResponse response = CandidateMapper.toResponse(candidate);

        // Verificar que los valores son correctos
        assertEquals("Jane Doe", response.getName());
        assertEquals("janedoe@example.com", response.getEmail());
        assertEquals("Female", response.getGender());
        assertEquals("60000.00", response.getExpectedSalary());
        assertEquals("Part-Time", response.getTypeOfContract());
    }
}
