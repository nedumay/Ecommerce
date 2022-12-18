package com.example.ecommerce.ui.cart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.ecommerce.R;
import com.example.ecommerce.ui.main.MainActivity;
import com.example.ecommerce.ui.product.ProductActivity;

public class CartActivity extends AppCompatActivity {

    private ImageView imageButtonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        initViews();

        imageButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = ProductActivity.productInent(CartActivity.this);
                startActivity(intent);
            }
        });

    }

    private void initViews() {
        imageButtonBack = findViewById(R.id.img_back_btn);
    }

    public static final Intent cartIntent(Context context){
        Intent intent = new Intent(context, CartActivity.class);
        return intent;
    }
}