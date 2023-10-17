package com.nocountryc14.listacheck.controller;

import com.nocountryc14.listacheck.model.User;
import com.nocountryc14.listacheck.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

@Autowired
private IUserService userService;

//CREAR
    @PostMapping("/users/create")
    public String createUser(@RequestBody User user){
      userService.saveUser(user);
        //devuelvo String q se creo correctamente
      return "El usuario fue creado correctamente";
    }

//consulta-read
@GetMapping("/users/get")
public List<User> getUser(){
   return userService.getUser();
}

//DELETE/BAJA

@DeleteMapping("users/delete/{id}")
public String deleteUser(@PathVariable Long id_user){
    userService.deleteUser(id_user);
    //devuelvo String q se creo correctamente
    return "El usuario fue borrado correctamente";
}

//BUSQUEDA por id
public void findUser(Long id_user){
        userService.findUser(id_user);
       }


}
