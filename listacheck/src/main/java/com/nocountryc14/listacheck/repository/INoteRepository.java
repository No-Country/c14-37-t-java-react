package com.nocountryc14.listacheck.repository;

import com.nocountryc14.listacheck.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INoteRepository extends JpaRepository<Note, Long> {
}
