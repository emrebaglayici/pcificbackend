package com.pcific.pcificbackend.Controllers.Dtos;

import com.pcific.pcificbackend.Entities.Role;
import com.pcific.pcificbackend.Entities.User;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
public class UserSignUpDto {
    private String name;
    private String username;
    private String password;

    public User toUser(){
        return User.builder()
                .username(this.username)
                .password(this.password)
                .name(this.name)
                .createTime(LocalDateTime.now())
                .role(Role.USER)
                .build();
    }
}
