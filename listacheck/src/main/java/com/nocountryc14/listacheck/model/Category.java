package com.nocountryc14.listacheck.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;


@Getter
@Entity
public class Category {


    //Getter Setters
    //Attributes
    @Id
    @GeneratedValue
    Long id;
    String name;


    //Constructors
    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }


    //Tostring
    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Long getCategoryId() {
        return null;
    }

    public String getCategoryName() {
        return null;
    }

    public void setCategoryId(Long categoryId) {
    }

    public void setCategoryName(String categoryName) {
    }
}
