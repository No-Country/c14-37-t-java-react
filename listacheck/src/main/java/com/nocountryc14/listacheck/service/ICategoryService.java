package com.nocountryc14.listacheck.service;

import com.nocountryc14.listacheck.dto.BrandDto;
import com.nocountryc14.listacheck.dto.CategoryDto;
import com.nocountryc14.listacheck.model.Category;

import java.util.List;

public interface ICategoryService {


    // This method is used to create a brand
    CategoryDto createCategory(CategoryDto categoryDto);

    List<CategoryDto> getCategories();

    void deleteCategory(Long id_category);

    CategoryDto findCategoryById(Long id_category);

    CategoryDto findCategoryByName(String name);

    CategoryDto updateCategory(Long id_category, CategoryDto updatedCategoryDto);

}
