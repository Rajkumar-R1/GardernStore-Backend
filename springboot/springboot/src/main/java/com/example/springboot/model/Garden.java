package com.example.springboot.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Garden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String gardenName;

    @OneToMany(mappedBy = "bus", cascade = CascadeType.ALL)
    private List<User> users;

    // Constructors, getters, and setters
    public Garden() {
    }

    public Garden(String gardenName) {
        this.gardenName = gardenName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getgardenName() {
        return gardenName;
    }

    public void setBusName(String gardenName) {
        this.gardenName = gardenName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
