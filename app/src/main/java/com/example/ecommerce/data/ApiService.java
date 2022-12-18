package com.example.ecommerce.data;

import com.example.ecommerce.domain.best.BestSeller;
import com.example.ecommerce.domain.home.HomeStore;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

public interface ApiService {

    @GET("654bd15e-b121-49ba-a588-960956b15175")
    Single<HomeStore> loadHomeStore();

    @GET("654bd15e-b121-49ba-a588-960956b15175")
    Single<BestSeller> loadBestSeller();
}
