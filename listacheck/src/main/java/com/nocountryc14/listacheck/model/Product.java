package com.nocountryc14.listacheck.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;
@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String productName;
    private Integer stock;

    @OneToOne
    private Category category;
    @OneToOne
    private Brand brand;

    @ManyToMany(mappedBy = "products")
    private Collection<List> lists = new ArrayList<>();

}
