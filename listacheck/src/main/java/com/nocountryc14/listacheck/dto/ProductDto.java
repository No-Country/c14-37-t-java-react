package com.nocountryc14.listacheck.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ProductDto {
    private Long id_product;

    private String name_product;

    private int quantity;

    private CategoryDto category;

    private BrandDto brand;
    private boolean buyed;

}
