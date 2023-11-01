package com.nocountryc14.listacheck.controller;


import com.nocountryc14.listacheck.model.User;
import com.nocountryc14.listacheck.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {

@Autowired
private IUserService userService;

//CREAR
    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user){
      User userSaved = userService.createUser(user);
        //devuelvo String q se creo correctamente
      return new ResponseEntity<>(userSaved, HttpStatus.CREATED);
    }

//consulta-read
@GetMapping("/get")
public List<User> getUser(){
        List<User> user = userService.getUser();
   return user;
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
