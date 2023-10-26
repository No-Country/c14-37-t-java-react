package com.nocountryc14.listacheck.mapper;

import com.nocountryc14.listacheck.dto.UserDto;
import com.nocountryc14.listacheck.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public static UserDto toUserDto(User user){
        UserDto userDto = new UserDto();
        if(user.getId() != null){
            userDto.setUserId(user.getId());
        }
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getMail());


        return userDto;
    }
    public static User toUser(UserDto userDto){
        User user = new User();
        if(userDto.getUserId() != null){
            user.setId(userDto.getUserId());
        }
        user.setFirstName(userDto.getFirstName());
        user.setMail(userDto.getEmail());

        return user;
    }
}
