package com.nocountryc14.listacheck.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Collection;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ShopListDto {

    private Long shopListId;

    private String shopListName;

    private UserDto shopListUser;

    private Collection<ProductDto> products;
}
