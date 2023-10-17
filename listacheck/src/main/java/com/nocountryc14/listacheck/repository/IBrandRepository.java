package com.nocountryc14.listacheck.repository;

import com.nocountryc14.listacheck.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBrandRepository extends JpaRepository<Brand, Long> {
    Brand findByName(String name);
}