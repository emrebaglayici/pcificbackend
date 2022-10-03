package com.pcific.pcificbackend.Web.Dtos;

import lombok.Getter;
import lombok.Setter;
import java.util.List;


@Setter @Getter
public class ProductCreateDto {

    private String name;
    private Double price;
    private String shortDescription;
    private String longDescription;
    private Boolean active;
    private Integer quantity;
    private List<Long> tags;
    private List<Long> categories;
    private List<Long> sizes;
}
