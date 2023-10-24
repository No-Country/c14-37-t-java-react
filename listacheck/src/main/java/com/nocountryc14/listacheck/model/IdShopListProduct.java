package com.nocountryc14.listacheck.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class IdShopListProduct implements Serializable {

    private Long shopListId;
    private Long productId;

    public void setShopListId(Long shopListId) {
        this.shopListId = shopListId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IdShopListProduct that)) return false;
        return Objects.equals(shopListId, that.shopListId) && Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shopListId, productId);
    }
}
