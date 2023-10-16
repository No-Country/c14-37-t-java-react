package com.nocountryc14.listacheck.mapper;

import com.nocountryc14.listacheck.dto.CategoryDto;
import com.nocountryc14.listacheck.model.Category;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryMapper {

            CategoryDto toDto(Category category);

            Category fromDto(CategoryDto categoryDto);
}
