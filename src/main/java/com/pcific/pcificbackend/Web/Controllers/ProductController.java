package com.pcific.pcificbackend.Web.Controllers;

import com.pcific.pcificbackend.Business.IProductService;
import com.pcific.pcificbackend.Entities.Image;
import com.pcific.pcificbackend.Entities.Product;
import com.pcific.pcificbackend.Web.Dtos.ProductCreateDto;
import com.pcific.pcificbackend.Web.Dtos.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@RestController
public class ProductController {
    @Autowired
    private IProductService iProductService;

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
