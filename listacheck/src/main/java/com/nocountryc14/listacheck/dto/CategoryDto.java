package com.nocountryc14.listacheck.dto;

import com.nocountryc14.listacheck.model.Product;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class CategoryDto {

    private Long categoryId;

    private String categoryName;

    private Set<Product> products = new HashSet<>();


}
