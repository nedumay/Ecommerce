package com.example.ecommerce.domain.product;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class Product implements Serializable {

    @SerializedName("CPU")
    private String cpu;
    @SerializedName("camera")
    private String camera;
    @SerializedName("capacity")
    private List<String> capacitys;
    @SerializedName("color")
    private List<String> colors;
    @SerializedName("id")
    private String id;
    @SerializedName("images")
    private List<String> images;
    @SerializedName("isFavorites")
    private Boolean isFavorites;
    @SerializedName("price")
    private int price;
    @SerializedName("rating")
    private double rating;
    @SerializedName("sd")
    private String sd;
    @SerializedName("ssd")
    private String ssd;
    @SerializedName("title")
    private String title;

    public Product(
            String cpu,
            String camera,
            List<String> capacitys,
            List<String> colors,
            String id,
            List<String> images,
            Boolean isFavorites,
            int price,
            double rating,
            String sd,
            String ssd,
            String title
    ) {
        this.cpu = cpu;
        this.camera = camera;
        this.capacitys = capacitys;
        this.colors = colors;
        this.id = id;
        this.images = images;
        this.isFavorites = isFavorites;
        this.price = price;
        this.rating = rating;
        this.sd = sd;
        this.ssd = ssd;
        this.title = title;
    }

    public String getCpu() {
        return cpu;
    }

    public String getCamera() {
        return camera;
    }

    public List<String> getCapacitys() {
        return capacitys;
    }

    public List<String> getColors() {
        return colors;
    }

    public List<String> getImages() {
        return images;
    }

    public String getId() {
        return id;
    }

    public Boolean getFavorites() {
        return isFavorites;
    }

    public int getPrice() {
        return price;
    }

    public double getRating() {
        return rating;
    }

    public String getSd() {
        return sd;
    }

    public String getSsd() {
        return ssd;
    }

    public String getTitle() {
        return title;
    }
}
