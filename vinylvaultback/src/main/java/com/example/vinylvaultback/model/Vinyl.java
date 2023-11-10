package com.example.vinylvaultback.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Vinyl implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private long id;
    private String name;
    private String artist;
    private String year;
    private String imageUrl;
    private String price;
    private long userId;

    public Vinyl() {}

    public Vinyl(String name, String artist, String year, String imageUrl, String price, Long userId) {
        this.name = name;
        this.artist = artist;
        this.year = year;
        this.imageUrl = imageUrl;
        this.price = price;
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUser_id(long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Vinyl{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", artist='" + artist + '\'' +
                ", year='" + year + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", price='" + price + '\'' +
                ", userId=" + userId +
                '}';
    }
}
