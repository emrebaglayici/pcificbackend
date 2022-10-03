package com.pcific.pcificbackend.Web.Controllers;

import com.pcific.pcificbackend.Business.IProductService;
import com.pcific.pcificbackend.Business.ISizeService;
import com.pcific.pcificbackend.Entities.Image;
import com.pcific.pcificbackend.Web.Dtos.ProductCreateDto;
import com.pcific.pcificbackend.Web.Dtos.ProductListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@RestController
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @Autowired
    private ISizeService iSizeService;

//    @PostMapping(value = {"/addNewProduct"},consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
//    public void addNewProduct(@RequestPart ProductCreateDto product,
//                                       @RequestPart("imageFile")MultipartFile[] file){
//        try {
//            Set<Image> images =uploadImage(file);
////            product
////            product.setProductImages(images);
//            iProductService.addNewProduct(product);
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//
//        }
//
//    }
    @PostMapping("product")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody ProductCreateDto dto){
        iProductService.saveProduct(dto);
    }

    @GetMapping("products")
    public Page<ProductListDto> listProducts(Pageable pageable){
        return iProductService.listProducts(pageable)
                .map(product -> ProductListDto.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .price(product.getPrice())
                        .shortDescription(product.getShortDescription())
                        .longDescription(product.getLongDescription())
                        .quantity(product.getQuantity())
                        .category(product.getCategory())
                        .tags(product.getTags())
                        .sizes(product.getSizes())
                        .build());
    }

    public Set<Image> uploadImage(MultipartFile[] multipartFiles) throws IOException {
        Set<Image> imageSet=new HashSet<>();
        for(MultipartFile file:multipartFiles){
            Image imageModel=new Image(
                    file.getOriginalFilename(),
                    file.getContentType(),
                    file.getBytes()
            );
            imageSet.add(imageModel);
        }
        return imageSet;
    }
}
