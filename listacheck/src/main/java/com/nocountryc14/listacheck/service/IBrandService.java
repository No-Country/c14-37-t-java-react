package com.nocountryc14.listacheck.service;

import com.nocountryc14.listacheck.dto.BrandDto;
import com.nocountryc14.listacheck.model.Brand;

import java.util.List;

public interface IBrandService {



    // This method is used to create a brand

    public Brand createBrand(BrandDto brandsDto);

    public List<Brand> getBrand();

    public void deleteBrand(Long id_brand);

    public Brand findBrandById(Long id_brand);

    public Brand findBrandByName(String name);

    public Brand updateBrand(Long id_brand, Brand updatedBrand);

}