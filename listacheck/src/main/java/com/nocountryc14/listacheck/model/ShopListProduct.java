package com.nocountryc14.listacheck.model;

import jakarta.persistence.*;

@Entity
public class ShopListProduct {

    @EmbeddedId
    private IdShopListProduct idShopListProduct = new IdShopListProduct();

    @ManyToOne
    @MapsId("shopListId")
    @JoinColumn(name = "shopListId")
    private Product product;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "productId")
    private ShopList shopList;
    private Integer quantity;



}
