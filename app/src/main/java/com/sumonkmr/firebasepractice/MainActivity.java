package com.sumonkmr.firebasepractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    androidx.appcompat.widget.AppCompatButton reg,login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reg = findViewById(R.id.reg);
        login = findViewById(R.id.login);

        reg.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this,Registation.class);
            startActivity(intent);
        });

        login.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this,Login.class);
            startActivity(intent);
        });


    }
}