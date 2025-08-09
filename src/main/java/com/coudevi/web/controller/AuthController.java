package com.coudevi.web.controller;

import com.coudevi.application.service.AuthService;
import com.coudevi.web.dto.request.LoginRequest;
import com.coudevi.web.dto.request.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login (@RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok(authService.authenticate(loginRequest));
    }
}
