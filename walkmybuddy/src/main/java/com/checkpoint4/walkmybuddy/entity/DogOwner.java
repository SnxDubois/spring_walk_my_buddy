package com.checkpoint4.walkmybuddy.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class DogOwner implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    private String email;

    @NotNull
    @NotEmpty
    @Size(min = 8)
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dogOwner")
    private Set<Dog> dogsOwned = new HashSet<>();

    public DogOwner() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Dog> getDogsOwned() {
        return dogsOwned;
    }

    public void setDogsOwned(Set<Dog> dogsOwned) {
        this.dogsOwned = dogsOwned;
    }
}
