package com.nocountryc14.listacheck.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
public class List {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long listId;

    private String listName;

    @ManyToOne
    private User listUser;

    @ManyToMany
    @JoinTable(
            name = "list_product",
            joinColumns = @JoinColumn(name = "list_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Collection<Product> products = new ArrayList<>();


}
