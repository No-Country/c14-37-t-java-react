package com.nocountryc14.listacheck.service;

import com.nocountryc14.listacheck.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserService {
    //Create
    void saveUser(User user);

    //Consulta-read
    List<User> getUser();

    //DELETE/BAJA
    void deleteUser(Long id_user);


    //Busqueda
    User findUser(Long id_user);
}
