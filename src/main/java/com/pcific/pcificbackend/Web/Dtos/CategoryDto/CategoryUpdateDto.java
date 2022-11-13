package com.pcific.pcificbackend.Web.Dtos.CategoryDto;

import com.pcific.pcificbackend.Entities.Category;
import lombok.Setter;

@Setter
public class CategoryUpdateDto {
    private String name;

    public Category toCategory() {
        return Category.builder()
                .name(this.name)
                .build();
    }
}
