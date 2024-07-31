package com.guy.class24b_and_7;

import java.util.ArrayList;
import java.util.HashMap;

public class User {

    private String id;
    private String name;
    private String email;
    private String image;
    private HashMap<String, Integer> purchased = new HashMap<>();
    private HashMap<String, Integer> favorites = new HashMap<>();

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public HashMap<String, Integer> getPurchased() {
        return purchased;
    }

    public void setPurchased(HashMap<String, Integer> purchased) {
        this.purchased = purchased;
    }

    public HashMap<String, Integer> getFavorites() {
        return favorites;
    }

    public void setFavorites(HashMap<String, Integer> favorites) {
        this.favorites = favorites;
    }

    public User addFavorite(String gameId) {
        this.favorites.put(gameId, 1);
        return this;
    }


    public User addPurchase(String gameId) {
        this.purchased.put(gameId, 1);
        return this;
    }
}
