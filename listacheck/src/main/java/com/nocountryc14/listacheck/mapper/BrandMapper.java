package com.nocountryc14.listacheck.mapper;

import com.nocountryc14.listacheck.dto.BrandDto;
import com.nocountryc14.listacheck.model.Brand;

public class BrandMapper {
    public static BrandDto toDto(Brand brand){
        BrandDto brandDto = new BrandDto();
        if(brand.getBrandId() != null){
            brandDto.setBrandId(brand.getBrandId());
        }


        brandDto.setBrandName(brand.getBrandName());

        return brandDto;
    }
}
