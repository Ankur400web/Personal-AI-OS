package com.personalai.os.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class LoginResponse {

    private String accessToken;
    private String tokenType;
    private UserResponse user;
}
