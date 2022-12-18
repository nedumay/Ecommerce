package com.example.ecommerce.domain.home;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HomeStore {

    @SerializedName("home_store")
    private List<Home> home;

    public HomeStore(List<Home> home) {
        home = home;
    }

    public List<Home> getHome() {
        return home;
    }

}
