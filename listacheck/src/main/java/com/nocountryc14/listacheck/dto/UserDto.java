package com.nocountryc14.listacheck.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.nocountryc14.listacheck.model.ShopList;
import lombok.Data;

import java.util.Collection;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class UserDto {

    private Long userId;

    private String firstName;
    private String lastName;

    private String email;

    private Collection<ShopList> shopLists;
}
