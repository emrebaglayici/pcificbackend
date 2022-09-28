package com.pcific.pcificbackend.Business;

import com.pcific.pcificbackend.Entities.Product;
import com.pcific.pcificbackend.Entities.Tags;
import com.pcific.pcificbackend.Web.Dtos.ProductCreateDto;

import java.util.Optional;

public interface IProductService {
//    void addNewProduct(ProductCreateDto dto);

    void saveProduct(ProductCreateDto dto);


}
