package com.pcific.pcificbackend.Web.Dtos.ProductDto;

import com.pcific.pcificbackend.Entities.Category;
import com.pcific.pcificbackend.Entities.Size;
import com.pcific.pcificbackend.Entities.Tags;
import com.pcific.pcificbackend.Web.Dtos.SizesDto.SizeListDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProductDto {
    private Long id;
    private String name;
    private Double price;
    private String shortDescription;
    private String longDescription;
    private Boolean active;
    private Integer quantity;
    private List<Tags> tags;
    private List<Category> categories;
    private List<Size> sizes;

    //changed sizelistdto to
}
