package com.nocountryc14.listacheck.controller;

import com.nocountryc14.listacheck.dto.UserDto;
import com.nocountryc14.listacheck.model.User;
import com.nocountryc14.listacheck.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

@Autowired
private IUserService userService;

//CREAR
    @PostMapping("/create")
    public String createUser(@RequestBody UserDto userDto){
      userService.createUser(userDto);
        //devuelvo String q se creo correctamente
      return "El usuario fue creado correctamente";
    }

//consulta-read
@GetMapping("/get")
public List<UserDto> getUser(){
   return userService.getUser();
}

//DELETE/BAJA

@DeleteMapping("/delete/{id}")
public String deleteUser(@PathVariable Long id_user){
    userService.deleteUser(id_user);
    //devuelvo String q se creo correctamente
    return "El usuario fue borrado correctamente";
}
//BUSQUEDA por id
    @GetMapping("/find/{id}")
    public void findUser(Long id_user){
        userService.findUserById(id_user);
    }
}
