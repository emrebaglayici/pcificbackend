package com.pcific.pcificbackend.Business.Concretes;

import com.pcific.pcificbackend.Business.Abstracts.ICategoryService;
import com.pcific.pcificbackend.Entities.Category;
import com.pcific.pcificbackend.Exceptions.NotFoundException;
import com.pcific.pcificbackend.Repositories.CategoryRepository;
import com.pcific.pcificbackend.Web.Dtos.CategoryDto.CategoryCreateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Optional;

@Service
public class CategoryManager implements ICategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void update(Long id, Category category) {
        this.categoryRepository.save(category);
    }

    @Override
    @ResponseStatus(HttpStatus.CREATED)
    public void createCategory(CategoryCreateDto dto) {
        categoryRepository.save(dto.toCategory());
    }

    @Override
    public Optional<Category> getById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Page<Category> listCategories(Pageable pageable) {
        return this.categoryRepository.findAll(pageable);
    }

    @Override
    public Category deleteById(Long id) {
        Optional<Category> optionalCategory=categoryRepository.findById(id);
        Category category=optionalCategory.orElseThrow(()->new NotFoundException("Category Not Found"));
        this.categoryRepository.deleteById(category.getId());
        return category;
    }

    @Override
    public boolean isExists(Long id) {
        return categoryRepository.existsById(id);
    }


}
