package com.nocountryc14.listacheck.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
public class ShopList {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shopListId;

    private String shopListName;

    @ManyToOne
    private User  shopListUser;

//    @ManyToMany
//    @JoinTable(
//            name = "shoplist_product",
//            joinColumns = @JoinColumn(name = "shoplist_id"),
//            inverseJoinColumns = @JoinColumn(name = "product_id"))
//    private Collection<Product> products = new ArrayList<>();

    @OneToMany(mappedBy = "shopList", cascade = CascadeType.ALL)
    private Collection<ShopListProduct> products = new ArrayList<>();




}
