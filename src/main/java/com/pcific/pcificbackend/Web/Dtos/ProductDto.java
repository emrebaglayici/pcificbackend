package com.pcific.pcificbackend.Web.Dtos;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@Builder
public class ProductDto {
    private Long id;
    private String name;
    private Double price;
    private String shortDescription;
    private String longDescription;
//    private CategoryDto category;
    private List<TagsDto> tags;
//    private Set<SizeDto> sizes;
}
