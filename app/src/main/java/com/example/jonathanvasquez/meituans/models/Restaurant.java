package com.example.jonathanvasquez.meituans.models;

import android.widget.ImageView;

import java.io.Serializable;

public class Restaurant implements Serializable {

    private String name;
    private String rating;
    private String priceRange;
    private String dealsBought;
    private int imageRes;

    public Restaurant(String name, String priceRange, String rating, String dealsBought, int imageRes) {
        this.name = name;
        this.rating = rating;
        this.priceRange = priceRange;
        this.dealsBought = dealsBought;
        this.imageRes = imageRes;
    }

    public String getPriceRange() {
        return this.priceRange;
    }

    public String getName() {
        return this.name;
    }

    public String getRating() {
        return this.rating;
    }

    public String getDealsBought() {
        return this.dealsBought;
    }

    public int getImageRes() { return this.imageRes; }
}
