package com.pcific.pcificbackend.Web.Dtos;

import com.pcific.pcificbackend.Entities.Category;
import com.pcific.pcificbackend.Entities.Tags;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@Builder
public class ProductDto {
    private Long id;
    private String name;
    private Double price;
    private String shortDescription;
    private String longDescription;
    private List<Tags> tags;
    private List<Category> categories;
    private List<SizeDto> sizes;
}
