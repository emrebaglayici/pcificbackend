package com.pcific.pcificbackend.Web.Dtos;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class SizeDto {
    private Long id;
    private String name;
    private Integer quantity;
}
