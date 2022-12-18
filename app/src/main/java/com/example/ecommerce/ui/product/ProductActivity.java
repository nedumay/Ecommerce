package com.example.ecommerce.ui.product;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.ecommerce.R;
import com.example.ecommerce.domain.home.Home;
import com.example.ecommerce.ui.cart.CartActivity;
import com.example.ecommerce.ui.main.MainActivity;

public class ProductActivity extends AppCompatActivity {

    private ImageView imageButtonBack;
    private ImageView imageButtonCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        initViews();

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

    private void initViews() {
        imageButtonBack = findViewById(R.id.img_back_btn);
        imageButtonCart = findViewById(R.id.img_cart_btn);
    }

    public static Intent productInent(Context context){
        Intent intent = new Intent(context,ProductActivity.class);
        return intent;
    }
}