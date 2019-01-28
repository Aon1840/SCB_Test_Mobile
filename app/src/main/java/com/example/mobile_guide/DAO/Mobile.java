package com.example.mobile_guide.DAO;

import com.google.gson.annotations.SerializedName;

public class Mobile {

    @SerializedName("id")               private int id;
    @SerializedName("description")      private String description;
    @SerializedName("name")             private String name;
    @SerializedName("brand")            private String brand;
    @SerializedName("price")            private double price;
    @SerializedName("rating")           private double rating;
    @SerializedName("thumbImageURL")    private String thumbImageURL;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getThumbImageURL() {
        return thumbImageURL;
    }

    public void setThumbImageURL(String thumbImageURL) {
        this.thumbImageURL = thumbImageURL;
    }
}
