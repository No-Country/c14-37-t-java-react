package com.nocountryc14.listacheck.mapper;

import com.nocountryc14.listacheck.dto.ProductDto;
import com.nocountryc14.listacheck.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public static ProductDto toProductDto(Product product){
        ProductDto productDto = new ProductDto();
        if(product.getProductId() != null){
            productDto.setProductId(product.getProductId());
        }
        productDto.setProductName(product.getProductName());
        productDto.setStock(product.getStock());
        productDto.setCategory(CategoryMapper.categoryDto(product.getCategory()));

        return productDto;
    }
    /*
      private Long productId;

    private String productName;

    private Integer stock;

    private CategoryDto category;

    private BrandDto brand;
     */
    public static Product toProduct(ProductDto productDto){
        Product product = new Product();
        if(productDto.getProductId() != null){
            product.setProductId(productDto.getProductId());
        }
        product.setProductName(productDto.getProductName());
        product.setStock(productDto.getStock());
        product.setCategory(CategoryMapper.category(productDto.getCategory()));
        return product;
    }
}
