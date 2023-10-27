package com.nocountryc14.listacheck.mapper;

import com.nocountryc14.listacheck.dto.ProductDto;
import com.nocountryc14.listacheck.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public static ProductDto toProductDto(Product product){
        ProductDto productDto = new ProductDto();
        if(product.getId_product() != null){
            productDto.setId_product(product.getId_product());
        }
        productDto.setName_product(product.getName_product());
        productDto.setQuantity(product.getQuantity());

        productDto.setBought(product.isBought());
        //productDto.setCategory(CategoryMapper.categoryDto(product.getCategory()));
        productDto.setBrand(BrandMapper.toDto(product.getBrand()));
        productDto.setCategory(CategoryMapper.toDto(product.getCategory()));
        productDto.setNote(NoteMapper.toDto(product.getNote()));
        return productDto;
    }

    public static Product toProduct(ProductDto productDto){
        Product product = new Product();
        if(productDto.getId_product() != null){
            product.setId_product(productDto.getId_product());
        }
        product.setName_product(productDto.getName_product());
        product.setQuantity(productDto.getQuantity());
        product.setBought(productDto.isBought());
        product.setBrand(BrandMapper.toBrand(productDto.getBrand()));
        product.setCategory(CategoryMapper.toCategory(productDto.getCategory()));
        product.setNote(NoteMapper.toNote(productDto.getNote()));
        return product;
    }
}
