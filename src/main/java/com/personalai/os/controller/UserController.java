package com.personalai.os.controller;


import com.personalai.os.dto.UserResponse;
import com.personalai.os.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/me")
    public ResponseEntity<UserResponse> getCurrentUser(Authentication authentication) {

        UUID userId = (UUID) authentication.getPrincipal();

        UserResponse response = userService.getUserById(userId);

        return ResponseEntity.ok(response);
    }
}
