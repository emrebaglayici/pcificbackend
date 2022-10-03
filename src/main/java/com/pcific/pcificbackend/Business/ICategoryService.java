package com.pcific.pcificbackend.Business;

import com.pcific.pcificbackend.Entities.Category;

import java.util.Optional;

public interface ICategoryService {
    Category createCategory(Category category);
    Optional<Category> getById(Long id);
}
