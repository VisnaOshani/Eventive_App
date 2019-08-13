package com.example.eventive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Add_Budgets extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__budgets);
    }

    public void addBudgets(View view){
        Intent intent = new Intent(Add_Budgets.this,Budget_Details.class);
        startActivity(intent);
    }

    public void back(View view){
        Intent intent = new Intent(Add_Budgets.this,Home.class);
        startActivity(intent);
    }
}
