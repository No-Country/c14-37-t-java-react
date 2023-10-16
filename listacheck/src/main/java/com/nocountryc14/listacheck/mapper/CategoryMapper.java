package com.nocountryc14.listacheck.mapper;

import com.nocountryc14.listacheck.dto.CategoryDto;
import com.nocountryc14.listacheck.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {

            CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);
            CategoryDto toDto(Category category);

            Category fromDto(CategoryDto categoryDto);
}
