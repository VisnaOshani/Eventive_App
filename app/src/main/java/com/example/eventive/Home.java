package com.example.eventive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

   public void budget(View view){
        Intent intent = new Intent(Home.this,Add_Budgets.class);
        startActivity(intent);
    }

    public void event(View view){
        Intent intent = new Intent(Home.this,Add_events.class);
        startActivity(intent);
    }


//    public void shopping(View view){
//        Intent intent = new Intent(this,shopping_main.class);
//        startActivity(intent);
//    }
}

