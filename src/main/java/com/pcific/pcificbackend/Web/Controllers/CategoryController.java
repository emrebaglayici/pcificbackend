package com.pcific.pcificbackend.Web.Controllers;

import com.pcific.pcificbackend.Business.Abstracts.ICategoryService;
import com.pcific.pcificbackend.Entities.Category;
import com.pcific.pcificbackend.Exceptions.NotFoundException;
import com.pcific.pcificbackend.Web.Dtos.CategoryDto.CategoryCreateDto;
import com.pcific.pcificbackend.Web.Dtos.CategoryDto.CategoryListDto;
import com.pcific.pcificbackend.Web.Dtos.CategoryDto.CategoryUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoryController {
    @Autowired
    private ICategoryService iCategoryService;

    @PostMapping("category")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCategory(@RequestBody CategoryCreateDto dto){
        iCategoryService.createCategory(dto);
    }

    @GetMapping("categories")
    public Page<CategoryListDto> listCategories(Pageable pageable){
        return iCategoryService.listCategories(pageable)
                .map(category-> CategoryListDto.builder()
                        .id(category.getId())
                        .name(category.getName())
                        .build());
    }

    @DeleteMapping("deleteCategory/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return ResponseEntity.ok(this.iCategoryService.deleteById(id));
    }

    @PatchMapping("updateCategory/{id}")
    public CategoryListDto update(@PathVariable Long id,@RequestBody CategoryUpdateDto dto){
        Category category=iCategoryService.getById(id).orElseThrow(()->new NotFoundException("Category Not Found"));
        boolean needUpdate=false;
        if (StringUtils.hasLength(dto.toCategory().getName())){
            category.setName(dto.toCategory().getName());
            needUpdate=true;
        }
        if (needUpdate)
            iCategoryService.update(id,category);
        return CategoryListDto.builder()
                .id(id)
                .name(category.getName())
                .build();
    }
}
