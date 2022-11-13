package com.pcific.pcificbackend.Web.Dtos.CategoryDto;

import com.pcific.pcificbackend.Entities.Category;
import lombok.Setter;

@Setter
public class CategoryCreateDto {
    private Long id;
    private String name;

    public Category toCategory(){
        return Category.builder()
                .id(this.id)
                .name((this.name))
                .build();
    }
}
