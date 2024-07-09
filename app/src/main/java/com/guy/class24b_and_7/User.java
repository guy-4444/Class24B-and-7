package com.guy.class24b_and_7;

import java.util.ArrayList;

public class User {

    private String id;
    private String name;
    private String email;
    private ArrayList<String> purchased = new ArrayList<>();
    private ArrayList<String> favorites = new ArrayList<>();

    public User() {}

    public User(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public User setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public ArrayList<String> getFavorites() {
        return favorites;
    }

    public User setFavorites(ArrayList<String> favorites) {
        this.favorites = favorites;
        return this;
    }

    public User addFavorite(String gameId) {
        this.favorites.add(gameId);
        return this;
    }

    public ArrayList<String> getPurchased() {
        return purchased;
    }

    public User setPurchased(ArrayList<String> purchased) {
        this.purchased = purchased;
        return this;
    }

    public User addPurchase(String gameId) {
        this.purchased.add(gameId);
        return this;
    }
}
