package com.pcific.pcificbackend.Business;

import com.pcific.pcificbackend.Entities.Product;
import com.pcific.pcificbackend.Web.Dtos.ProductCreateDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {

    void saveProduct(ProductCreateDto dto);
    Page<Product> listProducts(Pageable pageable);

}
