package com.example.eventive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Budget_Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget__details);
    }

    public void saveBudgets(View view){
        Intent intent = new Intent(Budget_Details.this,Add_Budgets.class);
        startActivity(intent);
    }












}





