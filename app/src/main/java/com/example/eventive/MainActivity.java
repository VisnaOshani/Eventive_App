package com.example.eventive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void login(View view){

        Intent intent = new Intent(MainActivity.this,Login.class);
        startActivity(intent);
    }

    public void goToHome(View view){
        Intent intent = new Intent(MainActivity.this,Home.class);
        startActivity(intent);
    }
}
