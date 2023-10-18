package com.nocountryc14.listacheck.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Collection;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class UserDto {

    private Long userId;

    private String firstName;

    private String lastName;

    private String email;

    private String password;
}
