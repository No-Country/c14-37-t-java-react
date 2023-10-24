package com.nocountryc14.listacheck.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_product;
    private String name_product;
    private int quantity;
    private boolean buyed;
    @ManyToOne()
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;
    //categoria
    //brand

    @ManyToMany(mappedBy = "products")
    private List<ShopList> shopLists = new ArrayList<>();

    public Product() {
    }

    public Product(Long id_product, String name_product, int quantity) {
        this.id_product = id_product;
        this.name_product = name_product;
        this.quantity = quantity;
    }

}
