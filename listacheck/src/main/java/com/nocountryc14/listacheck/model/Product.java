package com.nocountryc14.listacheck.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_product;
    private String name_product;
    private int stock;

    @ManyToOne()
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;
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
