package com.nocountryc14.listacheck.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Product {

    private Long id_product;
    private String name_product;
    private int stock;
    //categoria
    //brand

    public Product() {
    }

    public Product(Long id_product, String name_product, int stock) {
        this.id_product = id_product;
        this.name_product = name_product;
        this.stock = stock;
    }
}
