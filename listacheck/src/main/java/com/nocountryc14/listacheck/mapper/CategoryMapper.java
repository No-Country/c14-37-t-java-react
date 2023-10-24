package com.nocountryc14.listacheck.mapper;

import com.nocountryc14.listacheck.dto.CategoryDto;
import com.nocountryc14.listacheck.model.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    public static CategoryDto categoryDto(Category category){
        CategoryDto categoryDto = new CategoryDto();
        if(category.getCategoryId() != null){
            categoryDto.setCategoryId(category.getCategoryId());
        }
        categoryDto.setCategoryName(category.getCategoryName());

        return categoryDto;
    }
    public static Category category(CategoryDto categoryDto){
        Category category = new Category();
        if(categoryDto.getCategoryId() != null){
            category.setCategoryId(categoryDto.getCategoryId());
        }
        category.setCategoryName(categoryDto.getCategoryName());

        return category;
    }
}
