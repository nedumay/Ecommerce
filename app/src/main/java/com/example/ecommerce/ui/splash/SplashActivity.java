package com.example.ecommerce.ui.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.ecommerce.R;
import com.example.ecommerce.ui.main.MainActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread logoTimer = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        logoTimer.start();

    }
}