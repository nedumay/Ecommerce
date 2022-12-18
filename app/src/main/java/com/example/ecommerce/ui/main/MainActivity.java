package com.example.ecommerce.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;

import com.example.ecommerce.R;
import com.example.ecommerce.domain.best.Best;
import com.example.ecommerce.domain.home.Home;
import com.example.ecommerce.ui.product.ProductActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private CheckBox checkPhone;
    private CheckBox checkComputer;
    private CheckBox checkHealth;
    private CheckBox checkBooks;
    private CheckBox checkOther;
    private RecyclerView recyclerViewHotSales;
    private RecyclerView recyclerViewBestSeller;
    private Spinner spinnerCity;

    private HotSalesAdapter hotSalesAdapter;
    private BestSellerAdapter bestSellerAdapter;

    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        mainViewModel.getHomes().observe(this, new Observer<List<Home>>() {
            @Override
            public void onChanged(List<Home> homes) {
                hotSalesAdapter.setHomes(homes);
            }
        });

        mainViewModel.getBests().observe(this, new Observer<List<Best>>() {
            @Override
            public void onChanged(List<Best> bests) {
                bestSellerAdapter.setBest(bests);
            }
        });

        initViews();
        adapterSpinnerCity();
        checkBoxMenu();
        initAdapter();
    }

    private void initAdapter() {
        hotSalesAdapter = new HotSalesAdapter();
        recyclerViewHotSales.setAdapter(hotSalesAdapter);
        hotSalesAdapter.setOnClickListenerHot(new OnClickListenerHot() {
            @Override
            public void onClick(Home home) {
                Intent intent = ProductActivity.productInent(MainActivity.this);
                startActivity(intent);
            }
        });

        bestSellerAdapter = new BestSellerAdapter();
        recyclerViewBestSeller.setAdapter(bestSellerAdapter);
    }

    private void initViews() {

        checkPhone = findViewById(R.id.btn_check_phone);
        checkPhone.setChecked(true);

        checkComputer = findViewById(R.id.btn_check_computer);
        checkHealth = findViewById(R.id.btn_check_health);
        checkBooks = findViewById(R.id.btn_check_books);
        checkOther = findViewById(R.id.btn_check_other);
        recyclerViewHotSales = findViewById(R.id.rv_hot_sales);
        recyclerViewBestSeller = findViewById(R.id.rv_best_seller);
        spinnerCity = findViewById(R.id.choice_city);

    }

    private void checkBoxMenu() {
        checkPhone.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkPhone.setChecked(true);
                    checkComputer.setChecked(false);
                    checkBooks.setChecked(false);
                    checkHealth.setChecked(false);
                    checkOther.setChecked(false);
                }
                else {
                    checkPhone.setChecked(false);
                }
            }
        });

        checkComputer.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkPhone.setChecked(false);
                    checkComputer.setChecked(true);
                    checkBooks.setChecked(false);
                    checkHealth.setChecked(false);
                    checkOther.setChecked(false);
                }
                else {
                    checkComputer.setChecked(false);
                }
            }
        });

        checkBooks.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkPhone.setChecked(false);
                    checkComputer.setChecked(false);
                    checkBooks.setChecked(true);
                    checkHealth.setChecked(false);
                    checkOther.setChecked(false);
                }
                else {
                    checkBooks.setChecked(false);
                }
            }
        });

        checkHealth.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkPhone.setChecked(false);
                    checkComputer.setChecked(false);
                    checkBooks.setChecked(false);
                    checkHealth.setChecked(true);
                    checkOther.setChecked(false);
                }
                else {
                    checkHealth.setChecked(false);
                }
            }
        });

        checkOther.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkPhone.setChecked(false);
                    checkComputer.setChecked(false);
                    checkBooks.setChecked(false);
                    checkHealth.setChecked(false);
                    checkOther.setChecked(true);
                }
                else {
                    checkOther.setChecked(false);
                }
            }
        });

    }

    private void adapterSpinnerCity() {
        ArrayAdapter<?> adapter =ArrayAdapter.createFromResource(
                this,
                R.array.city,
                android.R.layout.simple_list_item_1
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCity.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {

    }

    public static final Intent mainIntent(Context context){
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

}