package com.pcific.pcificbackend.Business;

import com.pcific.pcificbackend.Entities.Product;
import com.pcific.pcificbackend.Repositories.ProductRepository;
import com.pcific.pcificbackend.Web.Dtos.ProductCreateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductManager implements IProductService{

    @Autowired
    private ProductRepository productRepository;

//    @Override
//    public void addNewProduct(ProductCreateDto dto) {
//         productRepository.save(Product.builder().price(dto.getPrice())
//                .name(dto.getName())
////                .tags(dto.getTags())
////                .size(dto.getSizes())
////                .category(dto.getCategory())
//                .longDescription(dto.getLongDescription())
//                .shortDescription(dto.getShortDescription())
//                .build());
//    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
}
