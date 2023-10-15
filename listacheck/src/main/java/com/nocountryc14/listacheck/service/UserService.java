package com.nocountryc14.listacheck.service;


import com.nocountryc14.listacheck.model.User;
import com.nocountryc14.listacheck.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService implements  IUserService  {


    private IUserRepository userRepository;

   //Create
    @Override
    public void saveUser(User user){
     userRepository.save(user);
    }

 //Consulta-read
   @Override
   public List<User> getUser(){
    List<User>listaUsuarios = userRepository.findAll();
    return listaUsuarios;
   }

//DELETE/BAJA
@Override
public void deleteUser(Long id_user){
   userRepository.deleteById(id_user);
}
//Busqueda
@Override
public User findUser(Long id_user){
    //si no encuentro el usuario devuelvo null;
     User user =userRepository.findById(id_user).orElse(null);
     return user;
}



}
