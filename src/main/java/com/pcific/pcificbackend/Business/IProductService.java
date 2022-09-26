package com.pcific.pcificbackend.Business;

import com.pcific.pcificbackend.Entities.Product;
import com.pcific.pcificbackend.Web.Dtos.ProductCreateDto;

public interface IProductService {
//    void addNewProduct(ProductCreateDto dto);

    Product saveProduct(Product product);
}
