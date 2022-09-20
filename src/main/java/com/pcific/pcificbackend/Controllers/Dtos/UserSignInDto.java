package com.pcific.pcificbackend.Controllers.Dtos;

import lombok.Data;

@Data
public class UserSignInDto {
    private String username;
    private String password;
}
