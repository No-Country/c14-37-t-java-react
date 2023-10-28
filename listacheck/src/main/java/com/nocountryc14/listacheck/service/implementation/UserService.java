package com.nocountryc14.listacheck.service.implementation;


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

 

    // This method is used to create a user.
    @Override
    public User createUser(User user) {

        User savedUser = userRepository.save(user);
        return savedUser;
    }

    // This method is used to get a list with all the users.
    @Override
    public List<User> getUser() {
       List<User> users = userRepository.findAll();
       return users;
    }



    // This method is used to delete a user by ID.
    @Override
    public void deleteUser(Long id_user) {
        userRepository.deleteById(id_user);

    }

    // This method is used to find a user by ID.
    @Override
    public User findUserById(Long id_user) {
        User user = userRepository.findById(id_user).orElse(null);
        return user;
    }

    // This method is used to update a user by ID.
    @Override
    public User updateUser(Long id_user, User updatesUser) {
       User existingUser = userRepository.findById(id_user).orElse(null);

       if (existingUser != null){
           existingUser.setUserId(updatesUser.getUserId());
           User savedUser = userRepository.save(existingUser);
           return savedUser;

       }else{
           return null;
       }

    }





}
