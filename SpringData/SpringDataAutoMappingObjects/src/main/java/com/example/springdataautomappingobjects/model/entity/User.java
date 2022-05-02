package com.example.springdataautomappingobjects.model.entity;

import com.example.springdataautomappingobjects.model.Role;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity{

    @Column(unique = true)
    private String email;
    @Column
    private String password;
    @Column
    private String fullName;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_games",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "game_id"))
    private Set<Game> games;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_shopping_cart_games",
            joinColumns = @JoinColumn(name = "user_id_shopping_cart"),
            inverseJoinColumns = @JoinColumn(name = "game_id"))
    private Set<Game> shoppingCart;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    public User() {
        this.games = new HashSet<>();
        this.shoppingCart = new HashSet<>();
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }



    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Set<Game> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(Set<Game> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
}
