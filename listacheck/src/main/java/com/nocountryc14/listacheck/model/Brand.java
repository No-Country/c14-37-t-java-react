package com.nocountryc14.listacheck.model;

<<<<<<< HEAD
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

=======

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Brand {

    @Id
    @GeneratedValue
    private Long brandId;

    private String name;

    public Brand(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return  "brand ID: " + brandId + ". Name: " + name;
    }
}
>>>>>>> origin/backend_feature_brand
