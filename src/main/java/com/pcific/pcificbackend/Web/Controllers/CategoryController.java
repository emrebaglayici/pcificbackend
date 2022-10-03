package com.pcific.pcificbackend.Web.Controllers;

import com.pcific.pcificbackend.Business.ICategoryService;
import com.pcific.pcificbackend.Entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {
    @Autowired
    private ICategoryService iCategoryService;

    @PostMapping("categories")
    public void addCategory(@RequestBody Category category){
        iCategoryService.createCategory(category);
    }
}
