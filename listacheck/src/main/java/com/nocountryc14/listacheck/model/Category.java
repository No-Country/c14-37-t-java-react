package com.nocountryc14.listacheck.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


@Entity
@Data
public class Category {


    //Attributes
    @Id
    @GeneratedValue
    Long categoryId;
    String categoryName;


    @OneToMany(mappedBy = "category")
    private List<Product> products = new ArrayList<>();



}
