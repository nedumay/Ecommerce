package com.example.ecommerce.domain.best;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Best implements Serializable {

    @SerializedName("id")
    private int id;
    @SerializedName("is_favorites")
    private Boolean is_favorites;
    @SerializedName("title")
    private String title;
    @SerializedName("price_without_discount")
    private int price_without_discount;
    @SerializedName("discount_price")
    private int discount_price;
    @SerializedName("picture")
    private String picture;

    public Best(int id, Boolean is_favorites, String title, int price_without_discount, int discount_price, String picture) {
        this.id = id;
        this.is_favorites = is_favorites;
        this.title = title;
        this.price_without_discount = price_without_discount;
        this.discount_price = discount_price;
        this.picture = picture;
    }

    public int getId() {
        return id;
    }

    public Boolean getIs_favorites() {
        return is_favorites;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice_without_discount() {
        return price_without_discount;
    }

    public int getDiscount_price() {
        return discount_price;
    }

    public String getPicture() {
        return picture;
    }
}
