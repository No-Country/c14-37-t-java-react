package com.nocountryc14.listacheck.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ProductDto {
    private Long productId;

    private String productName;

    private Integer stock;

    private CategoryDto category;

    private BrandDto brand;
}
