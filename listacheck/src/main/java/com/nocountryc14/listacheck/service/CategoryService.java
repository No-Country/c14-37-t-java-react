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

    private final ICategoryRepository iCategoryRepository;

    @Autowired
    public CategoryService(ICategoryRepository iCategoryRepository) {
        this.iCategoryRepository = iCategoryRepository;
    }

    //CREATE
    @Override
    public void saveCategory(Category prod) {
        iCategoryRepository.save(prod);
    }

    //READ
    @Override
    public List<Category> getCategory() {
        List<Category> listCategory = iCategoryRepository.findAll();
        return listCategory;
    }

    //DELETE
    @Override
    public void deleteCategory(Long id_category) {
        iCategoryRepository.deleteById(id_category);
    }

    //SEARCH
    @Override
    public Category findCategory(Long id_category) {
        //si no encuentro el producto devuelvo null;
        Category category = iCategoryRepository.findById(id_category).orElse(null);
        return category;
    }

}
