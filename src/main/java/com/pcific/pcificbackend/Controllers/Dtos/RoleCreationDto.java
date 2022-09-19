package com.pcific.pcificbackend.Controllers.Dtos;

import com.pcific.pcificbackend.Entities.Role;
import lombok.Setter;

@Setter
public class RoleCreationDto {
    private String name;
    public Role toRole(){
        return Role.builder()
                .name(this.name)
                .build();
    }
}
