package com.nocountryc14.listacheck.service;

import com.nocountryc14.listacheck.model.User;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface IUserService {
    User createUser(User user);

    List<User> getUser();

    void deleteUser(Long id_user);

    User findUserById(Long id_user);

    User updateUser(Long id_user, User updatesUser);
}
