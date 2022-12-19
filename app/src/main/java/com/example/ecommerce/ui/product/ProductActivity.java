package com.example.ecommerce.ui.product;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.ecommerce.R;
import com.example.ecommerce.domain.home.Home;
import com.example.ecommerce.ui.cart.CartActivity;
import com.example.ecommerce.ui.main.MainActivity;

import java.util.List;

public class ProductActivity extends AppCompatActivity {

    private ImageView imageButtonBack;
    private ImageView imageButtonCart;
    private RecyclerView recyclerViewProduct;
    private TextView textViewTitle;
    private CheckBox checkIsFavorites;
    private RatingBar ratingBar;
    private TextView textViewCPU;
    private TextView textViewCamera;
    private TextView textViewSsd;
    private TextView textViewSd;
    private CardView checkColor1;
    private CardView checkColor2;
    private TextView textViewPrice;

    private ProductImageAdapter productImageAdapter;

    private ProductViewModel productViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        productViewModel = new ViewModelProvider(this).get(ProductViewModel.class);

        initViews();
        initAdapters();

        productViewModel.getCpu().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String cpu) {
                textViewCPU.setText(cpu);
            }
        });

        productViewModel.getCamera().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String camera) {
                textViewCamera.setText(camera);
            }
        });


        productViewModel.getColors().observe(this, new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> colors) {
                Log.d("colors", colors.toString());

                checkColor1.setCardBackgroundColor(colors.get(0).hashCode());
                checkColor2.setCardBackgroundColor(colors.get(1).hashCode());
            }
        });

        productViewModel.getImages().observe(this, new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> images) {
                productImageAdapter.setImgs(images);
            }
        });

        productViewModel.getIsFavorites().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean isFavorites) {
                checkIsFavorites.setChecked(isFavorites);
            }
        });

        productViewModel.getPrice().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer price) {
                textViewPrice.setText("$" + String.valueOf(price));
            }
        });

        productViewModel.getRating().observe(this, new Observer<Double>() {
            @Override
            public void onChanged(Double rating) {
                ratingBar.setRating(Float.valueOf(String.valueOf(rating)));
            }
        });

        productViewModel.getSd().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String sd) {
                textViewSd.setText(sd);
            }
        });

        productViewModel.getSsd().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String ssd) {
                textViewSsd.setText(ssd);
            }
        });

        productViewModel.getTitle().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String title) {
                textViewTitle.setText(title);
            }
        });

        /*
        productViewModel.getCapacitys().observe(this, new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> strings) {
                textV
            }
        });*/

        imageButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = MainActivity.mainIntent(ProductActivity.this);
                startActivity(intent);
            }
        });

        imageButtonCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = CartActivity.cartIntent(ProductActivity.this);
                startActivity(intent);
            }
        });
    }

    private void initAdapters() {
        productImageAdapter = new ProductImageAdapter();
        recyclerViewProduct.setAdapter(productImageAdapter);
    }

    private void initViews() {
        imageButtonBack = findViewById(R.id.img_back_btn);
        imageButtonCart = findViewById(R.id.img_cart_btn);
        recyclerViewProduct = findViewById(R.id.recyclerView);
        textViewTitle = findViewById(R.id.title_phone);
        checkIsFavorites = findViewById(R.id.btn_favorite_prod);
        ratingBar = findViewById(R.id.rating_bar);
        textViewCPU = findViewById(R.id.text_cpu);
        textViewCamera = findViewById(R.id.text_camera);
        textViewSsd = findViewById(R.id.text_ssd);
        textViewSd = findViewById(R.id.text_sd);
        checkColor1 = findViewById(R.id.check_color_1);
        checkColor2 = findViewById(R.id.check_color_2);
        textViewPrice = findViewById(R.id.text_price);
    }

    public static Intent productInent(Context context){
        Intent intent = new Intent(context,ProductActivity.class);
        return intent;
    }
}