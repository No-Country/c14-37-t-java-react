package com.nocountryc14.listacheck.repository;

import com.nocountryc14.listacheck.model.ShopList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListRepository extends JpaRepository<ShopList, Long> {
}
