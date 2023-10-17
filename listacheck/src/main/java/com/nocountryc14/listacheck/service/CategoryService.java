package com.nocountryc14.listacheck.service;

import com.nocountryc14.listacheck.model.Category;
import com.nocountryc14.listacheck.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {


    @Autowired
    private ICategoryRepository categoryRepository;


    //CREATE
    @Override
    public void createCategory(Category prod) {
        categoryRepository.save(prod);
    }

    //READ
    @Override
    public List<Category> getCategory() {
        return categoryRepository.findAll();
    }

    //DELETE
    @Override
    public void deleteCategory(Long id_category) {
        categoryRepository.deleteById(id_category);
    }

    //SEARCH
    @Override
    public Category findCategory(Long id_category) {
        return categoryRepository.findById(id_category).orElse(null);
    }

    //UPDATE
    @Override
    public void updateCategory(Long id_category, Category category) {
        categoryRepository.deleteById(id_category);
    }


}
