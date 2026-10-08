package com.personalai.os.service;

import com.personalai.os.dto.RegisterRequest;
import com.personalai.os.dto.UserResponse;
import com.personalai.os.entity.User;
import com.personalai.os.exception.EmailAlreadyExistException;
import com.personalai.os.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public UserResponse createUser(RegisterRequest registerRequest){

        String email = registerRequest.getEmail()
                .trim()
                .toLowerCase();

        if (userRepository.existsByEmail(email)){
            throw new EmailAlreadyExistException("Email already used");
        }

       String passHash = passwordEncoder.encode(registerRequest.getPassword());

        User user = new User();

        user.setName(registerRequest.getName());
        user.setEmail(email);
        user.setPasswordHash(passHash);


        return mapToResponse(userRepository.save(user));

    }

    public UserResponse mapToResponse(User user){
        UserResponse response = new UserResponse();

        response.setId(user.getId());
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        response.setCreatedAt(user.getCreatedAt());

        return response;
    }

    public UserResponse getUserById(UUID userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return mapToResponse(user);
    }
}
