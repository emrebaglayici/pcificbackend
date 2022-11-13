package com.pcific.pcificbackend.Web.Dtos.ProductDto;

import com.pcific.pcificbackend.Entities.Category;
import com.pcific.pcificbackend.Entities.Product;
import com.pcific.pcificbackend.Entities.Size;
import com.pcific.pcificbackend.Entities.Tags;
import lombok.Setter;

import java.util.List;

@Setter
public class ProductUpdateDto {
    private String name;
    private Double price;
    private String shortDescription;
    private String longDescription;
    private Boolean active;
    private Integer quantity;
    private List<Size> sizes;
    private List<Category> category;
    private List<Tags> tags;

    public Product toProduct(){
        return Product.builder()
                .name(this.name)
                .price(this.price)
                .shortDescription(this.shortDescription)
                .longDescription(this.longDescription)
                .active(this.active)
                .quantity(this.quantity)
                .sizes(this.sizes)
                .category(this.category)
                .tags(this.tags)
                .build();
    }
}
