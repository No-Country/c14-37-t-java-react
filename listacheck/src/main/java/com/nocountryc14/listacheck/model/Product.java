package com.nocountryc14.listacheck.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter @Setter
@Entity
public class Product {

    private Long id_product;
    private String name_product;
    private int stock;
    @Id
    private Long id;
    //categoria
    //brand

    public Product() {
    }

    public Product(Long id_product, String name_product, int stock) {
        this.id_product = id_product;
        this.name_product = name_product;
        this.stock = stock;
    }

    public Long getProductId() {
        return null;
    }

    public String getProductName() {
        return null;
    }

    public Category getCategory() {
        return null;
    }

    public void setProductId(Long productId) {
    }

    public void setProductName(String productName) {
    }

    public void setCategory(Category category) {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
