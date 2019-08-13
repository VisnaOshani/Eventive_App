package com.example.eventive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void signup(View view){
        Intent intent = new Intent(Login.this,MainActivity.class);
        startActivity(intent);
    }

    public void goToHome(View view){
        Intent intent = new Intent(Login.this,Home.class);
        startActivity(intent);
    }
}
