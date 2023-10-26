package com.nocountryc14.listacheck.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.nocountryc14.listacheck.model.Product;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class BrandDto {

    private Long brandId;

    private String brandName;




}
