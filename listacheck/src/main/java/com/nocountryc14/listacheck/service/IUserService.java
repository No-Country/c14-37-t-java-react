package com.nocountryc14.listacheck.service;

import com.nocountryc14.listacheck.dto.UserDto;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface IUserService {
    UserDto createUser(UserDto userDto);

    List<UserDto> getUser();

    void deleteUser(Long id_user);

    UserDto findUserById(Long id_user);

    UserDto updateUser(Long id_user, UserDto updatesUserDto);
}
