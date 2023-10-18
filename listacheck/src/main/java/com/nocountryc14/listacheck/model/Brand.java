package com.nocountryc14.listacheck.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
public class Brand {

    @Id
    @GeneratedValue
    private Long brandId;

    private String brandName;

    public Brand(String name) {
        this.brandName = name;
    }

    @OneToMany(mappedBy = "brand")
    private Collection<Product> products;

    @Override
    public String toString() {
        return  "brand ID: " + brandId + ". Name: " + name;
    }
}
