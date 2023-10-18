package com.nocountryc14.listacheck.repository;

import com.nocountryc14.listacheck.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Long> {
}
