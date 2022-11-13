package com.pcific.pcificbackend.Business.Abstracts;

import com.pcific.pcificbackend.Entities.Category;
import com.pcific.pcificbackend.Web.Dtos.CategoryDto.CategoryCreateDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICategoryService {

    void update(Long id,Category category);
    void createCategory(CategoryCreateDto category);
    Optional<Category> getById(Long id);

    Page<Category> listCategories(Pageable pageable);

    Category deleteById(Long id);
    boolean isExists(Long id);
}
