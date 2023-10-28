package com.nocountryc14.listacheck.controller;


import com.nocountryc14.listacheck.model.Category;
import com.nocountryc14.listacheck.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    // Create
    @PostMapping("/create")
    public ResponseEntity<Category> createCategory(@RequestBody Category category) throws RuntimeException{
        if (category.getCategoryName() == null) {
            throw new RuntimeException("Category must have a name");
        }
        //categoryService.createCategory(category);
        return new ResponseEntity<>(categoryService.createCategory(category), HttpStatus.CREATED);
    }

    // Get
    @GetMapping("/get")
    public ResponseEntity<List<Category>> getCategories() {
        List<Category> categories = categoryService.getCategories();
        if (categories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(categories, HttpStatus.OK);
        }
    }

    // Delete
    @DeleteMapping("/delete/{id_category}")
    public ResponseEntity<Category> deleteCategory(@PathVariable Long id_category) {
        Category category = categoryService.findCategoryById(id_category);
        if (category != null) {
            categoryService.deleteCategory(id_category);
            return new ResponseEntity<>(category, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Find by ID
    @GetMapping("/{id_category}")
    public ResponseEntity<Category> findCategoryById(@PathVariable Long id_category) {
        Category category = categoryService.findCategoryById(id_category);
        if (category != null) {
            return new ResponseEntity<>(category, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Find by name
    @GetMapping("/findByName")
    public ResponseEntity<Category> findCategoryByName(@RequestParam String categoryName) {
        Category category = categoryService.findCategoryByName(categoryName);
        if (category != null) {
            return new ResponseEntity<>(category, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update
    @PutMapping("/update/{id_category}")
    public ResponseEntity<Category> updateCategory (@PathVariable Long id_category, @RequestBody Category updatedCategory) {
        Category category = categoryService.updateCategory(id_category, updatedCategory);
        if (category != null) {
            return new ResponseEntity<>(category, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}