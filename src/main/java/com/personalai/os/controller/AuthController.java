package com.personalai.os.controller;


import com.personalai.os.dto.LoginRequest;
import com.personalai.os.dto.LoginResponse;
import com.personalai.os.dto.RegisterRequest;
import com.personalai.os.dto.UserResponse;
import com.personalai.os.security.JwtAuthenticationFilter;
import com.personalai.os.service.AuthService;
import com.personalai.os.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;
    private final AuthService authService;

    public AuthController(UserService userService, AuthService authService) {
        this.userService = userService;
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(@RequestBody @Valid RegisterRequest registerRequest){
        UserResponse response = userService.createUser(registerRequest);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginUser(@RequestBody @Valid LoginRequest loginRequest){
        LoginResponse response = authService.login(loginRequest);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }



}
