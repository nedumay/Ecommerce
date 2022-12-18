package com.example.ecommerce.domain.best;

import com.example.ecommerce.domain.home.Home;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BestSeller {
    @SerializedName("best_seller")

    private List<Best> best;

    public BestSeller(List<Best> best) {
        this.best = best;
    }

    public List<Best> getBest() {
        return best;
    }
}
