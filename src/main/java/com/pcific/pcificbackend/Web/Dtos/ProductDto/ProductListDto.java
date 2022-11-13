package com.pcific.pcificbackend.Web.Dtos.ProductDto;

import com.pcific.pcificbackend.Entities.Category;
import com.pcific.pcificbackend.Entities.Size;
import com.pcific.pcificbackend.Entities.Tags;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data @Builder
public class ProductListDto {
    private Long id;
    private String name;
    private Double price;
    private String shortDescription;
    private String longDescription;
    private Integer quantity;
    private List<Category> category;
    private List<Tags> tags;
    private List<Size> sizes;
}
