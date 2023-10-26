package com.nocountryc14.listacheck.controller;

import com.nocountryc14.listacheck.dto.CategoryDto;
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
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) throws RuntimeException{
        if (categoryDto.getCategoryName() == null) {
            throw new RuntimeException("Category must have a name");
        }
        //categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(categoryService.createCategory(categoryDto), HttpStatus.CREATED);
    }

    // Get
    @GetMapping("/get")
    public ResponseEntity<List<CategoryDto>> getCategories() {
        List<CategoryDto> categoriesDto = categoryService.getCategories();
        if (categoriesDto.isEmpty()) {
            return new ResponseEntity<>(categoriesDto, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    // Delete
    @DeleteMapping("/delete/{id_category}")
    public ResponseEntity<CategoryDto> deleteCategory(@PathVariable Long id_category) {
        CategoryDto categoryDto = categoryService.findCategoryById(id_category);
        if (categoryDto != null) {
            categoryService.deleteCategory(id_category);
            return new ResponseEntity<>(categoryDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Find by ID
    @GetMapping("/{id_category}")
    public ResponseEntity<CategoryDto> findCategoryById(@PathVariable Long id_category) {
        CategoryDto categoryDto = categoryService.findCategoryById(id_category);
        if (categoryDto != null) {
            return new ResponseEntity<>(categoryDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Find by name
    @GetMapping("/findByName")
    public ResponseEntity<CategoryDto> findCategoryByName(@RequestParam String categoryName) {
        CategoryDto categoryDto = categoryService.findCategoryByName(categoryName);
        if (categoryDto != null) {
            return new ResponseEntity<>(categoryDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update
    @PutMapping("/update/{id_category}")
    public ResponseEntity<CategoryDto> updateCategory (@PathVariable Long id_category, @RequestBody CategoryDto updatedCategoryDto) {
        CategoryDto categoryDto = categoryService.updateCategory(id_category, updatedCategoryDto);
        if (categoryDto != null) {
            return new ResponseEntity<>(categoryDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}