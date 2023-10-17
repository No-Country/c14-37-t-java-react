package com.nocountryc14.listacheck.repository;

import com.nocountryc14.listacheck.model.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListRepository extends JpaRepository<List, Long> {
}
