package com.nocountryc14.listacheck.mapper;

import com.nocountryc14.listacheck.dto.UserDto;
import com.nocountryc14.listacheck.model.User;
import org.mapstruct.Mapper;


@Mapper
public interface UserMapper {

    UserDto toDto(User user);

    User fromDto(UserDto userDto);
}

