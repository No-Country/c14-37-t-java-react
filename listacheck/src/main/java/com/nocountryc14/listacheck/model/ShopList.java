package com.nocountryc14.listacheck.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
public class ShopList {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long shopListId;

    private String shopListName;
    private LocalDateTime shopListUpdateDate;
    @ManyToOne
    private User  shopListUser;
    @ManyToMany
    @JoinTable(
            name = "ShopList_Product",
            joinColumns = @JoinColumn(name = "shopList_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products = new ArrayList<>();

}
