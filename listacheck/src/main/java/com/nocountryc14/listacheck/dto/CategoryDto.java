package com.nocountryc14.listacheck.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.nocountryc14.listacheck.model.Product;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class CategoryDto {

    private Long categoryId;

    private String categoryName;




}
