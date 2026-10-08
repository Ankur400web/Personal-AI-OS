package com.personalai.os.service;

import com.personalai.os.dto.LoginRequest;
import com.personalai.os.dto.LoginResponse;
import com.personalai.os.dto.UserResponse;
import com.personalai.os.entity.User;
import com.personalai.os.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public LoginResponse login(LoginRequest request){
        String email = request.getEmail()
                .trim()
                .toLowerCase();

        User user = userRepository.findByEmail(email)
                .orElseThrow(()-> new RuntimeException("User doesn't exist"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPasswordHash())){
            throw new RuntimeException("Incorrect password");
        }

        String accessToken = jwtService.generateToken(user.getId());



        return new LoginResponse(
                accessToken,
                "Bearer",
                mapToResponse(user)

        );


    }

    public UserResponse mapToResponse(User user){
        UserResponse response = new UserResponse();

        response.setId(user.getId());
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        response.setCreatedAt(user.getCreatedAt());

        return response;
    }
}
