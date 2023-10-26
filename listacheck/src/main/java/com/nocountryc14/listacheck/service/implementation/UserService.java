package com.nocountryc14.listacheck.service.implementation;

import com.nocountryc14.listacheck.dto.UserDto;
import com.nocountryc14.listacheck.mapper.UserMapper;
import com.nocountryc14.listacheck.model.User;
import com.nocountryc14.listacheck.repository.IUserRepository;
import com.nocountryc14.listacheck.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    private UserMapper userMapper;

    // This method is used to create a user.
    @Override
    public UserDto createUser(UserDto userDto) {
        User user = userMapper.toUser(userDto);
        User savedUser = userRepository.save(user);
        return userMapper.toUserDto(savedUser);
    }

    // This method is used to get a list with all the users.
    @Override
    public List<UserDto> getUser() {
       List<User> users = userRepository.findAll();
       return users.stream().map(UserMapper::toUserDto).collect(Collectors.toList());
    }



    // This method is used to delete a user by ID.
    @Override
    public void deleteUser(Long id_user) {
        userRepository.deleteById(id_user);

    }

    // This method is used to find a user by ID.
    @Override
    public UserDto findUserById(Long id_user) {
        User user = userRepository.findById(id_user).orElse(null);
        return (user != null) ? userMapper.toUserDto(user): null;
    }

    // This method is used to update a user by ID.
    @Override
    public UserDto updateUser(Long id_user, UserDto updatesUserDto) {
       User existingUser = userRepository.findById(id_user).orElse(null);

       if (existingUser != null){
           existingUser.setId(updatesUserDto.getUserId());
           User savedUser = userRepository.save(existingUser);
           return userMapper.toUserDto(savedUser);

       }else{
           return null;
       }

    }





}
