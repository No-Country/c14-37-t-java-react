package com.nocountryc14.listacheck.mapper;

import com.nocountryc14.listacheck.dto.UserDto;
import com.nocountryc14.listacheck.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public static UserDto toUserDto(User user){
        UserDto userDto = new UserDto();
        if(user.getUserId() != null){
            userDto.setUserId(user.getUserId());
        }
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());

        return userDto;
    }
    public static User toUser(UserDto userDto){
        User user = new User();
        if(userDto.getUserId() != null){
            user.setUserId(userDto.getUserId());
        }
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        return user;
    }
}
