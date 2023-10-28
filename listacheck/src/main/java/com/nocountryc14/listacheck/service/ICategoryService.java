package com.nocountryc14.listacheck.service;

import com.nocountryc14.listacheck.model.Category;

import java.util.List;

public interface ICategoryService {


    // This method is used to create a brand
    Category createCategory(Category category);

    List<Category> getCategories();

    void deleteCategory(Long id_category);

    Category findCategoryById(Long id_category);

    Category findCategoryByName(String name);

    Category updateCategory(Long id_category, Category updatedCategory);

}
