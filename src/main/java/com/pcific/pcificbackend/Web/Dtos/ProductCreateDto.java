package com.pcific.pcificbackend.Web.Dtos;

import com.pcific.pcificbackend.Entities.Product;
import com.pcific.pcificbackend.Entities.Tags;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;


@Setter @Getter
public class ProductCreateDto {

    private String name;
    private Double price;
    private String shortDescription;
    private String longDescription;
    private List<Long> tagsList;
    private Set<Long> tags;
//    private Set<Size> sizes;
//    private Category category;

    public Product toProduct(){
        return Product.builder()
                .name(this.name)
                .price(this.price)
                .shortDescription(this.shortDescription)
                .longDescription(this.longDescription)

                .build();
    }
}
