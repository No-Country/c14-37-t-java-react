package com.nocountryc14.listacheck.model;

import jakarta.persistence.*;

@Entity
public class ShopListProduct {

    @EmbeddedId
    private IdShopListProduct idShopListProduct = new IdShopListProduct();

    @ManyToOne
    @MapsId("shopListId")
    @JoinColumn(name = "shoplist_id")
    private Product product;
    @MapsId("product_id")
    @JoinColumn(name = "product_id")
    private ShopList shopList;
    private Integer quantity;



}
