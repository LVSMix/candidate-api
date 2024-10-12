package com.reto.seek.demo.infraestructure.controller;

import com.reto.seek.demo.application.service.CandidateService;
import com.reto.seek.demo.infraestructure.controller.impl.CandidateControllerImpl;
import com.reto.seek.demo.infraestructure.request.CandidateRequest;
import com.reto.seek.demo.infraestructure.response.CandidateResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CandidateControllerImplTest {

    @Mock
    private CandidateService candidateService;

    @InjectMocks
    private CandidateControllerImpl candidateController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetCandidates() {
        // Datos simulados
        CandidateResponse candidate1 = new CandidateResponse("John Doe", "johndoe@example.com", "masculino","100", "Full-Time");
        CandidateResponse candidate2 = new CandidateResponse("Jane Doe", "janedoe@example.com", "masculino","10000", "Part-Time");

        // Simulación del servicio
        when(candidateService.getCandidates()).thenReturn(Arrays.asList(candidate1, candidate2));

        // Ejecutar la prueba
        ResponseEntity<List<CandidateResponse>> response = candidateController.getCandidates();

        // Verificar los resultados
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(2, response.getBody().size());
        assertEquals("John Doe", response.getBody().get(0).getName());

        // Verificar que el método del servicio fue llamado
        verify(candidateService, times(1)).getCandidates();
    }

    @Test
    public void testGetCandidate() {
        // Dato simulado
        CandidateResponse candidateResponse = new CandidateResponse("John Doe", "johndoe@example.com", "Male", "10000", "Full-Time");

        // Simulación del servicio
        when(candidateService.getCandidate(1L)).thenReturn(candidateResponse);

        // Ejecutar la prueba
        ResponseEntity<CandidateResponse> response = candidateController.getCandidate(1L);

        // Verificar los resultados
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("John Doe", response.getBody().getName());

        // Verificar que el método del servicio fue llamado
        verify(candidateService, times(1)).getCandidate(1L);
    }

    @Test
    public void testCreateCandidate() {
        // Datos simulados
        CandidateRequest candidateRequest = new CandidateRequest("John Doe", "johndoe@example.com", "Male", "1000",  "Full-Time");
        CandidateResponse candidateResponse = new CandidateResponse("John Doe", "johndoe@example.com", "Male","10000","Full-Time");

        // Simulación del servicio
        when(candidateService.createCandidate(candidateRequest)).thenReturn(candidateResponse);

        // Ejecutar la prueba
        ResponseEntity<CandidateResponse> response = candidateController.createCandidate(candidateRequest);

        // Verificar los resultados
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("John Doe", response.getBody().getName());

        // Verificar que el método del servicio fue llamado
        verify(candidateService, times(1)).createCandidate(candidateRequest);
    }

    @Test
    public void testUpdateCandidate() {
        // Datos simulados
        CandidateRequest candidateRequest = new CandidateRequest("John Doe", "johndoe@example.com", "Male", "1000", "Full-Time");
        CandidateResponse candidateResponse = new CandidateResponse( "John Doe", "johndoe@example.com", "Male", "1000", "Full-Time");

        // Simulación del servicio
        when(candidateService.updateCandidate(candidateRequest, 1L)).thenReturn(candidateResponse);

        // Ejecutar la prueba
        ResponseEntity<CandidateResponse> response = candidateController.updateCandidate(candidateRequest, 1L);

        // Verificar los resultados
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("John Doe", response.getBody().getName());

        // Verificar que el método del servicio fue llamado
        verify(candidateService, times(1)).updateCandidate(candidateRequest, 1L);
    }

    @Test
    public void testDeleteCandidate() {
        // Ejecutar la prueba
        ResponseEntity<Void> response = candidateController.deleteCandidate(1L);

        // Verificar los resultados
        assertEquals(204, response.getStatusCodeValue());

        // Verificar que el método del servicio fue llamado
        verify(candidateService, times(1)).deleteCandidate(1L);
    }
}

