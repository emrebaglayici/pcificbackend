package com.pcific.pcificbackend.Web.Dtos;

import com.pcific.pcificbackend.Entities.Category;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class CategoryDto {
    private Long id;
    private String name;
    public Category toCategory(){
        return Category.builder()
                .id(this.id)
                .name(this.name)
                .build();
    }
}
