package com.nocountryc14.listacheck.service.implementation;

import com.nocountryc14.listacheck.dto.CategoryDto;
import com.nocountryc14.listacheck.mapper.CategoryMapper;
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
    @Autowired
    private CategoryMapper categoryMapper;


    // This method is used to create a category.
    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category  = categoryMapper.toCategory(categoryDto);
        Category savedCategory = categoryRepository.save(category);
        return categoryMapper.toDto(savedCategory);
    }

    // This method is used to get a list with all the categories.
    @Override
    public List<CategoryDto> getCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(categoryMapper::toDto).collect(Collectors.toList());
    }

    // This method is used to delete a category by ID.
    @Override
    public void deleteCategory(Long id_category) {
        categoryRepository.deleteById(id_category);
    }

    // This method is used to find a category by ID.
    @Override
    public CategoryDto findCategoryById(Long id_category) {
        Category category = categoryRepository.findById(id_category).orElse(null);
        return (category != null) ? categoryMapper.toDto(category) : null;
    }

    // This method is used to find a category by name.
    @Override
    public CategoryDto findCategoryByName(String categoryName) {
        Category category = categoryRepository.findByCategoryName(categoryName);
        return (category != null) ? categoryMapper.toDto(category) : null;
    }

    // This method is used to update a category by ID.
    @Override
    public CategoryDto updateCategory(Long id_category, CategoryDto updatedCategoryDto) {
        Category existingCategory = categoryRepository.findById(id_category).orElse(null);

        if (existingCategory != null) {
            existingCategory.setCategoryName(updatedCategoryDto.getCategoryName());
            Category savedCategory = categoryRepository.save(existingCategory);
            return categoryMapper.toDto(savedCategory);
        } else {
            return null;
        }
    }


}
