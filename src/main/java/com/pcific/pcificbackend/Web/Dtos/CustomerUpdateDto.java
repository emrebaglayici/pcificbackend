package com.pcific.pcificbackend.Web.Dtos;

import com.pcific.pcificbackend.Entities.User;
import lombok.Setter;

@Setter
public class CustomerUpdateDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    public User toUser(){
        return User.builder()
                .id(this.id)
                .firstName(this.firstName)
                .lastName(this.lastName)
                .email(this.email)
                .build();
    }
}
