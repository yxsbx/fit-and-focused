package com.fitandfocused.service;

import com.fitandfocused.dto.LoginRequest;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public String loginWithGoogle(LoginRequest loginRequest) {
        return "token";
    }
}
