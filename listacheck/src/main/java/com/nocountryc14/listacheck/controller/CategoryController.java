package com.nocountryc14.listacheck.controller;


import com.nocountryc14.listacheck.dto.BrandDto;
import com.nocountryc14.listacheck.dto.CategoryDto;
import com.nocountryc14.listacheck.model.Category;
import com.nocountryc14.listacheck.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    // Create
    @PostMapping("/create")
    public String createCategory(@RequestBody CategoryDto categoryDto) {
        categoryService.createCategory(categoryDto);
        return "The category " + categoryDto.toString() + " has been created successfully.";
    }


    // Get
    @GetMapping("/get")
    public String getCategories() {

        List<CategoryDto> categories = categoryService.getCategories();

        if (categories.isEmpty()) {
            return "No category has been added yet.";
        } else {
            return categories.toString();
        }
    }

    // Delete
    @DeleteMapping("/delete/{id_category}")
    public String deleteCategory(@PathVariable Long id_category) {

        CategoryDto categoryDto = categoryService.findCategoryById(id_category);

        if (categoryDto != null) {
            categoryService.deleteCategory(id_category);
            return "The category " + categoryDto.toString() + " has been deleted successfully.";
        } else {
            return "There is no category with this ID to delete.";
        }
    }

    // Find by ID
    @GetMapping("/{id_category}")
    public String findCategoryById(@PathVariable Long id_category) {
        CategoryDto categoryDto = categoryService.findCategoryById(id_category);

        if (categoryDto != null) {
            return categoryDto.toString();
        } else {
            return "There is no category with this ID.";
        }
    }

    // Find by name
    @GetMapping("/findByName")
    public String findCategoryByName(@RequestParam String categoryName) {
        CategoryDto categoryDto = categoryService.findCategoryByName(categoryName);

        if (categoryDto != null) {
            return categoryDto.toString();
        } else {
            return "There is no category with this name.";
        }
    }

    // Update
    @PutMapping("/update/{id_category}")
    public String updateCategory (@PathVariable Long id_category, @RequestBody CategoryDto updatedCategoryDto) {

        CategoryDto categoryDto = categoryService.findCategoryById(id_category);

        if (categoryDto != null) {
            categoryService.updateCategory(id_category, updatedCategoryDto);
            return "The category " + categoryDto.toString() + " has been updated successfully.";
        } else {
            return "There is no category with this ID to update.";
        }
    }
}