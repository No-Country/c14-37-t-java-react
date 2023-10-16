package com.nocountryc14.listacheck.controller;


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
    public String createCategory(@RequestBody Category category) {
        categoryService.createCategory(category);
        return "The category have been created successfully.";
    }


    // Get
    @GetMapping("/get")
    public String getBrand() {

        List<Category> categorys = categoryService.getCategory();

        if (categorys.isEmpty()) {
            return "No category has been added yet.";
        } else {
            return categorys.toString();
        }
    }

    // Delete
    @DeleteMapping("/delete/{id_category}")
    public String deleteCategory(@PathVariable Long id_category) {

        Category category = categoryService.findCategory(id_category);

        if (category != null) {
            categoryService.deleteCategory(id_category);
            return "The category has been deleted successfully.";
        } else {
            return "There is no category with this ID to delete.";
        }
    }

    // Find
    @GetMapping("/{id_category}")
    public String findCategory(@PathVariable Long id_category) {

        Category category = categoryService.findCategory(id_category);

        if (category != null) {
            return category.toString();
        } else {
            return "There is no brand with this ID.";
        }
    }



//    // Update
    @PutMapping("/update/{id_category}")
    public String updateCategory (@PathVariable Long id_category, @RequestBody Category updatedCategory) {

        Category category = categoryService.findCategory(id_category);

        if (category != null) {
            categoryService.updateCategory(id_category, updatedCategory);
            return "The brand has been updated successfully.";
        } else {
            return "There is no brand with this ID to update.";
        }
    }

}
