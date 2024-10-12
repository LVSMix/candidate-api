package com.reto.seek.demo.domain.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.Date;

public class CandidateTest {

    private Candidate candidate;

    @BeforeEach
    public void setUp() {
        candidate = new Candidate();
        candidate.setId(1L);
        candidate.setName("John Doe");
        candidate.setEmail("johndoe@example.com");
        candidate.setGender("Male");
        candidate.setExpectedSalary(BigDecimal.valueOf(50000));
        candidate.setCreatedAt(new Date());
        candidate.setActive(true);
        candidate.setUpdatedAt(new Date());
        candidate.setTypeOfContract("Full-Time");
    }

    @Test
    public void testCandidateProperties() {
        assertEquals(1L, candidate.getId());
        assertEquals("John Doe", candidate.getName());
        assertEquals("johndoe@example.com", candidate.getEmail());
        assertEquals("Male", candidate.getGender());
        assertEquals(BigDecimal.valueOf(50000), candidate.getExpectedSalary());
        assertTrue(candidate.getActive());
        assertNotNull(candidate.getCreatedAt());
        assertNotNull(candidate.getUpdatedAt());
        assertEquals("Full-Time", candidate.getTypeOfContract());
    }
}

