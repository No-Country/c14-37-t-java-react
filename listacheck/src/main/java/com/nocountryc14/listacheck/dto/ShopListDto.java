package com.nocountryc14.listacheck.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ShopListDto {

    private Long shopListId;

    private String shopListName;

    //private UserDto shopListUser;

    private List<ProductDto> products;

    public ShopListDto() {
        products = new ArrayList<>();
    }
}
