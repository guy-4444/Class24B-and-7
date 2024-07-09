package com.guy.class24b_and_7;

public class Game {

    public enum GENRE {
        STRATEGY,
        ARCADE,
        ACTION,
        RACING,
        SPORTS,
    }

    private String id;
    private String title;
    private GENRE genre;
    private int downloads;
    private long reviews;
    private double rating;
    private boolean isSafe;

    public Game() {}

    public String getId() {
        return id;
    }

    public Game setId(String id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Game setTitle(String title) {
        this.title = title;
        return this;
    }

    public GENRE getGenre() {
        return genre;
    }

    public Game setGenre(GENRE genre) {
        this.genre = genre;
        return this;
    }

    public int getDownloads() {
        return downloads;
    }

    public Game setDownloads(int downloads) {
        this.downloads = downloads;
        return this;
    }

    public long getReviews() {
        return reviews;
    }

    public Game setReviews(long reviews) {
        this.reviews = reviews;
        return this;
    }

    public double getRating() {
        return rating;
    }

    public Game setRating(double rating) {
        this.rating = rating;
        return this;
    }

    public boolean isSafe() {
        return isSafe;
    }

    public Game setSafe(boolean safe) {
        isSafe = safe;
        return this;
    }
}
