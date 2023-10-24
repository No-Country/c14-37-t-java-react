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
        productDto.setBuyed(product.isBuyed());

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
        if(productDto.getId_product() != null){
            product.setId_product(productDto.getId_product());
        }
        product.setName_product(productDto.getName_product());
        product.setQuantity(productDto.getQuantity());
        product.setBuyed(productDto.isBuyed());
        product.setCategory(CategoryMapper.category(productDto.getCategory()));
        return product;
    }
}
