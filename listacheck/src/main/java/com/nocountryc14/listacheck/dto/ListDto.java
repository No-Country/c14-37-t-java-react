package com.nocountryc14.listacheck.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ListDto {

    private Long listId;

    private String listName;

    private UserDto listUser;

    private Collection<ProductDto> products;
}
