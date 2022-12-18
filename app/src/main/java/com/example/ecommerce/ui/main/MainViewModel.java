package com.example.ecommerce.ui.main;

import android.app.Application;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecommerce.data.ApiFactory;
import com.example.ecommerce.domain.best.Best;
import com.example.ecommerce.domain.best.BestSeller;
import com.example.ecommerce.domain.home.Home;
import com.example.ecommerce.domain.home.HomeStore;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainViewModel extends AndroidViewModel {

    private MutableLiveData<List<Home>> homes = new MutableLiveData();
    public LiveData<List<Home>> getHomes() {
        return homes;
    }

    private MutableLiveData<List<Best>> bests = new MutableLiveData();
    public LiveData<List<Best>> getBests() {return bests;}

    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    public MainViewModel(@NonNull Application application) {
        super(application);
        loadHotSales();
        loadBestSeller();
    }

    private void loadBestSeller() {
        Disposable disposable = ApiFactory.apiService.loadBestSeller()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<BestSeller>() {
                    @Override
                    public void accept(BestSeller bestSeller) throws Throwable {
                        List<Best> loadBestSeller = bests.getValue();
                        if(loadBestSeller!=null){
                            loadBestSeller.addAll(bestSeller.getBest());
                            bests.setValue(loadBestSeller);
                        } else {
                            bests.setValue(bestSeller.getBest());
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Throwable {
                        Log.d("MainViewModel", throwable.toString());
                    }
                });
        compositeDisposable.add(disposable);
    }




    private void loadHotSales() {

        Disposable disposable = ApiFactory.apiService.loadHomeStore()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<HomeStore>() {
                    @Override
                    public void accept(HomeStore homeStore) throws Throwable {
                        List<Home> loadHotSales = homes.getValue();
                        if (loadHotSales != null) {
                            loadHotSales.addAll(homeStore.getHome());
                            homes.setValue(loadHotSales);
                        } else {
                            homes.setValue(homeStore.getHome());
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Throwable {
                        Log.d("MainViewModel", throwable.toString());
                    }
                });
        compositeDisposable.add(disposable);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.clear();
    }

}
