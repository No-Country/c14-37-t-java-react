package com.nocountryc14.listacheck.mapper;

import com.nocountryc14.listacheck.dto.UserDto;
import com.nocountryc14.listacheck.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public static UserDto toUserDto(User user){
        UserDto userDto = new UserDto();
        if(user.getUserId(userDto.getUserId()) != null){
            userDto.setUserId(user.getUserId(userDto.getUserId()));
        }
        userDto.getFirstName();
        userDto.getLastName();
        userDto.getEmail();
        userDto.setPassword(user.getPassword());

        return userDto;
    }
    public static User toUser(UserDto userDto){
        User user = new User();

        if(userDto.getUserId() != null){
            user.getUserId(userDto.getUserId());

        }
        user.setFirstName(userDto.getFirstName());
        user.setMail(userDto.getEmail());

        user.setPassword(userDto.getPassword());
        return user;
    }
}
