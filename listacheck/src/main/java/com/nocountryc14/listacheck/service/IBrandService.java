package com.nocountryc14.listacheck.service;

import com.nocountryc14.listacheck.model.Brand;

import java.util.List;

public interface IBrandService {

    public List<Brand> createBrand(List<Brand> brands);

    public List<Brand> getBrand();

    public void deleteBrand(Long id_brand);

    public Brand findBrandById(Long id_brand);

    public Brand findBrandByName(String name);

    public Brand updateBrand(Long id_brand, Brand updatedBrand);

}