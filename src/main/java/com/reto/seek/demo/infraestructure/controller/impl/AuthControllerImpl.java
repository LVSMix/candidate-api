package com.reto.seek.demo.infraestructure.controller.impl;


import com.reto.seek.demo.infraestructure.controller.AuthController;
import com.reto.seek.demo.infraestructure.request.LoginRequest;
import com.reto.seek.demo.infraestructure.utils.JWTTokenGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthControllerImpl implements AuthController {

    @Value("${pe.com.seek.seek-candidates-manager.user}")
    private String user;
    @Value("${pe.com.seek.seek-candidates-manager.pass}")
    private String pass;

    private final JWTTokenGenerator jwtTokenGenerator;

    @PostMapping
    public ResponseEntity<Map<String, String>> getToken(@RequestBody LoginRequest credentials) {
        return Optional.ofNullable(credentials)
                .filter(creds -> user.equals(creds.getUsername()) && pass.equals(creds.getPassword()))
                .map(creds -> jwtTokenGenerator.getJWTToken(creds.getUsername()))
                .map(token -> ResponseEntity.ok(Map.of("token", token)))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(Map.of("error", "Username or password incorrect")));
    }

}
