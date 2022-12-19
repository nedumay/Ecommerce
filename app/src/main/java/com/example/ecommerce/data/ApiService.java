package com.example.ecommerce.data;

import com.example.ecommerce.domain.best.BestSeller;
import com.example.ecommerce.domain.home.HomeStore;
import com.example.ecommerce.domain.product.Product;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

public interface ApiService {

    @GET("654bd15e-b121-49ba-a588-960956b15175")
    Single<HomeStore> loadHomeStore();

    @GET("654bd15e-b121-49ba-a588-960956b15175")
    Single<BestSeller> loadBestSeller();

    @GET("6c14c560-15c6-4248-b9d2-b4508df7d4f5")
    Single<Product> loadProduct();
}
