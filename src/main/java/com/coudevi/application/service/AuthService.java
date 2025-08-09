package com.coudevi.application.service;

import com.coudevi.web.dto.request.LoginRequest;
import com.coudevi.web.dto.request.LoginResponse;

public interface AuthService {
    LoginResponse authenticate(LoginRequest request);

}
