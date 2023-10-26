package com.nocountryc14.listacheck.model;



import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long brandId;

    private String brandName;

    @OneToMany(mappedBy = "brand")
    private Collection<Product> products;

    public Brand(String name) {
        this.brandName = name;
    }

}
