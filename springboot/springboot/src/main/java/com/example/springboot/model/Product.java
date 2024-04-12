package com.example.springboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String ProductDetails;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    // Constructors, getters, and setters
    public Product() {
    }

    public Product(String ProductDetails) {
        this.ProductDetails = ProductDetails;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductDetails() {
        return ProductDetails;
    }

    public void setBookingDetails(String ProductDetails) {
        this.ProductDetails = ProductDetails;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
