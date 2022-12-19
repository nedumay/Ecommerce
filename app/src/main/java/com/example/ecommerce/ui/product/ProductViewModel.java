package com.example.ecommerce.ui.product;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.ecommerce.data.ApiFactory;
import com.example.ecommerce.domain.product.Product;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ProductViewModel extends AndroidViewModel {

    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    private MutableLiveData<String> cpu = new MutableLiveData();
    public LiveData<String> getCpu() {return cpu;}

    private MutableLiveData<String> camera = new MutableLiveData();
    public LiveData<String> getCamera() {return camera;}

    private MutableLiveData<List<String>> capacitys = new MutableLiveData();
    public LiveData<List<String>> getCapacitys() {return capacitys;}

    private MutableLiveData<List<String>> colors = new MutableLiveData();
    public LiveData<List<String>> getColors () {return colors ;}

    private MutableLiveData<List<String>> images = new MutableLiveData();
    public LiveData<List<String>> getImages () {return images ;}

    private MutableLiveData<Boolean> isFavorites = new MutableLiveData();
    public LiveData<Boolean> getIsFavorites() {return isFavorites;}

    private MutableLiveData<Integer> price = new MutableLiveData();
    public LiveData<Integer> getPrice() {return price;}

    private MutableLiveData<Double> rating = new MutableLiveData();
    public LiveData<Double> getRating() {return rating;}

    private MutableLiveData<String> sd = new MutableLiveData();
    public LiveData<String> getSd() {return sd;}

    private MutableLiveData<String> ssd = new MutableLiveData();
    public LiveData<String> getSsd() {return ssd;}

    private MutableLiveData<String> title = new MutableLiveData();
    public LiveData<String> getTitle() {return title;}

    public ProductViewModel(@NonNull Application application) {
        super(application);
        loadProduct();
    }

    private void loadProduct() {
        Disposable disposable = ApiFactory.apiService.loadProduct()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Product>() {
                    @Override
                    public void accept(Product product) throws Throwable {
                        cpu.setValue(product.getCpu());
                        camera.setValue(product.getCamera());
                        capacitys.setValue(product.getCapacitys());
                        colors.setValue(product.getColors());
                        images.setValue(product.getImages());
                        isFavorites.setValue(product.getFavorites());
                        price.setValue(product.getPrice());
                        rating.setValue(product.getRating());
                        sd.setValue(product.getSd());
                        ssd.setValue(product.getSsd());
                        title.setValue(product.getTitle());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Throwable {
                        Log.d("ProductViewModel", throwable.toString());
                    }
                });
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.clear();
    }
}
