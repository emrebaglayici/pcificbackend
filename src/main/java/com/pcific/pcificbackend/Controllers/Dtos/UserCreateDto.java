package com.pcific.pcificbackend.Controllers.Dtos;

import com.pcific.pcificbackend.Entities.Role;
import com.pcific.pcificbackend.Entities.Users;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

import java.util.Collection;

@Setter
public class UserCreateDto {
    private Long id;
    private String name;
    private String username;
    private String password;
    private Collection<Role> roles;

    public Users toUser(){
        return Users.builder()
                .id(this.id)
                .name(this.name)
                .username(this.username)
                .roles(this.roles)
                .password(this.password)
                .build();
    }
}
