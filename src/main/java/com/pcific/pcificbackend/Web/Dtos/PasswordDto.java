package com.pcific.pcificbackend.Web.Dtos;

import com.pcific.pcificbackend.Validation.ValidPassword;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PasswordDto {

    private String oldPassword;

    private  String token;

    @ValidPassword
    private String newPassword;
}