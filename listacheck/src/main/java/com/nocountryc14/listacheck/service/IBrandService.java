package com.nocountryc14.listacheck.service;

import com.nocountryc14.listacheck.dto.BrandDto;


import java.util.List;

public interface IBrandService {


    BrandDto createBrand(BrandDto brandDto);

    List<BrandDto> getBrands();

    void deleteBrand(Long id_brand);

    BrandDto findBrandById(Long id_brand);

    BrandDto findBrandByName(String brandName);

    BrandDto updateBrand(Long id_brand, BrandDto updatedBrandDto);

}