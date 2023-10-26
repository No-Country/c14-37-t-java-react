package com.nocountryc14.listacheck.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Note {
    @Id
    @GeneratedValue
    private Long noteId;
    private String noteField;
}
