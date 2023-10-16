package com.nocountryc14.listacheck.service;

import com.nocountryc14.listacheck.model.Category;

import java.util.List;

public interface ICategoryService {


    void saveCategory(Category prod);
    public List<Category> getCategory();
    public void deleteCategory(Long id_category);
    public Category findCategory(Long id_category);

}
