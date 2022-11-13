package com.pcific.pcificbackend.Web.Dtos;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class CustomerListDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
