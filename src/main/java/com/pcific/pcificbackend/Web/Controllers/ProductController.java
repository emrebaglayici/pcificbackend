package com.pcific.pcificbackend.Web.Controllers;

import com.pcific.pcificbackend.Business.Abstracts.ICategoryService;
import com.pcific.pcificbackend.Business.Abstracts.IProductService;
import com.pcific.pcificbackend.Business.Abstracts.ISizeService;
import com.pcific.pcificbackend.Business.Abstracts.ITagService;
import com.pcific.pcificbackend.Entities.Product;
import com.pcific.pcificbackend.Entities.Size;
import com.pcific.pcificbackend.Exceptions.MustBeGraterThanZero;
import com.pcific.pcificbackend.Exceptions.NotFoundException;
import com.pcific.pcificbackend.Web.Dtos.ProductDto.ProductCreateDto;
import com.pcific.pcificbackend.Web.Dtos.ProductDto.ProductDto;
import com.pcific.pcificbackend.Web.Dtos.ProductDto.ProductListDto;
import com.pcific.pcificbackend.Web.Dtos.ProductDto.ProductUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @Autowired
    private ISizeService iSizeService;

    @Autowired
    private ICategoryService iCategoryService;

    @Autowired
    private ITagService iTagService;

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

    @DeleteMapping("deleteProduct/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return ResponseEntity.ok(this.iProductService.deleteById(id));
    }

    @PatchMapping("updateProduct/{id}")
    public ProductDto update(@PathVariable Long id,@RequestBody ProductUpdateDto dto){
        Product product=iProductService.getById(id).orElseThrow(()->new NotFoundException("Product not found"));
        List<Long> sizeIdList=new ArrayList<>();
        for (int i = 0; i < dto.toProduct().getSizes().size(); i++) {
            sizeIdList.add(dto.toProduct().getSizes().get(i).getId());
        }
        for (Long aLong : sizeIdList) {
            if (!iSizeService.isExists(aLong)) {
                throw new NotFoundException("Size not found");
            }
        }
        List<Long> categoryIdList=new ArrayList<>();
        for (int i = 0; i < dto.toProduct().getCategory().size(); i++) {
            categoryIdList.add(dto.toProduct().getCategory().get(i).getId());
        }
        for (Long data:categoryIdList) {
            if (!iCategoryService.isExists(data)){
                throw new NotFoundException("Category not found");
            }
        }

        List<Long> tagIdList=new ArrayList<>();
        for (int i = 0; i < dto.toProduct().getTags().size(); i++) {
            tagIdList.add(dto.toProduct().getTags().get(i).getId());
        }
        for (Long data:tagIdList) {
            if (!iTagService.isExists(data)){
                throw new NotFoundException("Tag not found");
            }
        }

        boolean needUpdate=false;
        if (StringUtils.hasLength(dto.toProduct().getName())){
            product.setName(dto.toProduct().getName());
            needUpdate=true;
        }
        if (!Objects.equals(dto.toProduct().getPrice(), product.getPrice())){
            if (dto.toProduct().getPrice()>0){
                product.setPrice(dto.toProduct().getPrice());
                needUpdate=true;
            }else{
                throw new MustBeGraterThanZero("Price must be greater than zero");
            }
        }
        if (StringUtils.hasLength(dto.toProduct().getShortDescription())){
            product.setShortDescription(dto.toProduct().getShortDescription());
            needUpdate=true;
        }
        if (StringUtils.hasLength(dto.toProduct().getLongDescription())){
            product.setLongDescription(dto.toProduct().getLongDescription());
            needUpdate=true;
        }
        if (dto.toProduct().getActive()!=product.getActive()){
            product.setActive(dto.toProduct().getActive());
            needUpdate=true;
        }
        if (dto.toProduct().getQuantity()!= product.getQuantity()){
            product.setQuantity(dto.toProduct().getQuantity());
            needUpdate=true;
        }
        product.setSizes(dto.toProduct().getSizes());
        product.setCategory(dto.toProduct().getCategory());
        product.setTags(dto.toProduct().getTags());

        if (needUpdate)
            iProductService.update(id,product);

        return ProductDto.builder()
                .id(id)
                .name(product.getName())
                .price(product.getPrice())
                .shortDescription(product.getShortDescription())
                .longDescription(product.getLongDescription())
                .active(product.getActive())
                .quantity(product.getQuantity())
                .sizes(product.getSizes())
                .categories(product.getCategory())
                .tags(product.getTags())
                .build();
    }
}
