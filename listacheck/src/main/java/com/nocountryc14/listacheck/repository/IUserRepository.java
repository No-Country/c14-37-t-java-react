package com.nocountryc14.listacheck.repository;


import com.nocountryc14.listacheck.model.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface IUserRepository extends JpaRepository<User,Long> {



}
