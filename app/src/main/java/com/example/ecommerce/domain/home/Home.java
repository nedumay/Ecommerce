package com.example.ecommerce.domain.home;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Home implements Serializable {

    @SerializedName("id")
    private int id;
    @SerializedName("is_new")
    private Boolean is_new;
    @SerializedName("title")
    private String title;
    @SerializedName("subtitle")
    private String  subtitle;
    @SerializedName("picture")
    private String picture;
    @SerializedName("is_buy")
    private Boolean is_buy;

    public Home(int id, Boolean is_new, String title, String subtitle, String picture, Boolean is_buy) {
        this.id = id;
        this.is_new = is_new;
        this.title = title;
        this.subtitle = subtitle;
        this.picture = picture;
        this.is_buy = is_buy;
    }

    public int getId() {
        return id;
    }

    public Boolean getIs_new() {
        return is_new;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getPicture() {
        return picture;
    }

    public Boolean getIs_buy() {
        return is_buy;
    }
}
