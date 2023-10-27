package com.nocountryc14.listacheck.model;




import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "APP_USER")
 public class User {

//Atributos

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @Column(name ="firstName")
    private String firstName;

    @Column(name= "lastName")
    private  String lastName;

    private String email;

    private String password;

    @OneToMany
    private Collection<ShopList> shoplists;

//Constructores

    public User() {
    }

    public User(Long id, String firstName, String lastName, String mail, String password) {
        userId = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = mail;
        this.password = password;

    }

    public User(String firstName, String lastName, String mail, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = mail;
        this.password = password;
    }

    // Getters and setters


    public Long getId() {
        return userId;
    }

    public void setId(Long id) {
        userId = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
        return email;
    }

    public void setMail(String mail) {
        this.email = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //metodo to string
    @Override
    public String toString() {
        return "User{" +
                "Id=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mail='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
