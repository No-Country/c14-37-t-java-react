package com.nocountryc14.listacheck.service.implementation;


import com.nocountryc14.listacheck.model.Category;
import com.nocountryc14.listacheck.repository.ICategoryRepository;
import com.nocountryc14.listacheck.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements ICategoryService {


    @Autowired
    private ICategoryRepository categoryRepository;



    // This method is used to create a category.
    @Override
    public Category createCategory(Category category) {

        Category savedCategory = categoryRepository.save(category);
        return savedCategory;
    }

    // This method is used to get a list with all the categories.
    @Override
    public List<Category> getCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories;
    }

    // This method is used to delete a category by ID.
    @Override
    public void deleteCategory(Long id_category) {
        categoryRepository.deleteById(id_category);
    }

    // This method is used to find a category by ID.
    @Override
    public Category findCategoryById(Long id_category) {
        Category category = categoryRepository.findById(id_category).orElse(null);
        return category;
    }

    // This method is used to find a category by name.
    @Override
    public Category findCategoryByName(String categoryName) {
        Category category = categoryRepository.findByCategoryName(categoryName);
        return category;
    }

    // This method is used to update a category by ID.
    @Override
    public Category updateCategory(Long id_category, Category updatedCategory) {
        Category existingCategory = categoryRepository.findById(id_category).orElse(null);

        if (existingCategory != null) {
            existingCategory.setCategoryName(updatedCategory.getCategoryName());
            Category savedCategory = categoryRepository.save(existingCategory);
            return savedCategory;
        } else {
            return null;
        }
    }


}
