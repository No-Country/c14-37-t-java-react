package com.nocountryc14.listacheck.dto;

import com.nocountryc14.listacheck.model.Product;
import lombok.Data;

import java.util.Collection;

@Data
public class BrandDto {

    private Long brandId;

    private String brandName;
    private Collection<Product> products;
}
