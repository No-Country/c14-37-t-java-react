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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long shopListId;

    private String shopListName;
    //private LocalDateTime shopListUpdateDate;
    /*
    @ManyToOne
    private User  shopListUser;
    */

    //Unidirectional
    @OneToMany
    private List<Product> products = new ArrayList<>();

}
