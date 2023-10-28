package com.nocountryc14.listacheck.service;

import com.nocountryc14.listacheck.model.Brand;


import java.util.List;

public interface IBrandService {


    Brand createBrand(Brand brand);

    List<Brand> getBrands();

    void deleteBrand(Long id_brand);

    Brand findBrandById(Long id_brand);

    Brand findBrandByName(String brandName);

    Brand updateBrand(Long id_brand, Brand updatedBrand);

}