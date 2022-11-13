package com.pcific.pcificbackend.Business.Abstracts;

import com.pcific.pcificbackend.Entities.Product;
import com.pcific.pcificbackend.Web.Dtos.ProductDto.ProductCreateDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IProductService {
    Optional<Product> getById(Long id);
    void saveProduct(ProductCreateDto dto);
    Page<Product> listProducts(Pageable pageable);
    Product deleteById(Long id);

    void update(Long id,Product product);

}
