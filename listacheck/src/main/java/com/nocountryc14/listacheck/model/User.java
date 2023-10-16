package com.nocountryc14.listacheck.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;

@Entity
@Data
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String name;

    private String email;
    private String password;

    @OneToMany(mappedBy = "listUser")
    private Collection<List> lists;


}
