package com.nocountryc14.listacheck.repository;


import com.nocountryc14.listacheck.model.Brand;
import com.nocountryc14.listacheck.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository <Category, Long> {

    Category findByCategoryName(String name);

}
