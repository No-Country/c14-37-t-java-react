package com.nocountryc14.listacheck.mapper;

import com.nocountryc14.listacheck.dto.ProductDto;
import com.nocountryc14.listacheck.model.Product;
import org.mapstruct.Mapper;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(ProductMapper.class);
    ProductDto toDto(Product product);

    Product fromDto(ProductDto productDto);
}
