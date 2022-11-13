package com.pcific.pcificbackend.Web.Dtos.CategoryDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryListDto {
    private Long id;
    private String name;
}
