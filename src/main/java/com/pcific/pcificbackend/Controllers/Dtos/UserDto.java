package com.pcific.pcificbackend.Controllers.Dtos;

import com.pcific.pcificbackend.Entities.Role;
import lombok.Builder;
import lombok.Data;
import java.util.Collection;

@Data
@Builder
public class UserDto {
    private Long id;
    private String name;
    private String username;
    private Collection<Role> roles;
}
