package com.nocountryc14.listacheck.mapper;

import com.nocountryc14.listacheck.dto.BrandDto;
import com.nocountryc14.listacheck.model.Brand;
import org.mapstruct.Mapper;

@Mapper
public interface BrandMapper {

        BrandDto toDto(Brand brand);

        Brand fromDto(BrandDto brandDto);
}
