package com.example.eventive;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

import Adapters.budgetAdapter;
import DataBase.DBHelper;
import Models.Fbudget;

public class Add_Budgets extends AppCompatActivity {

    private ArrayList<Fbudget> arrayList;
    DBHelper db;
    RecyclerView rv;
    EditText txt_note,text_bala;
    Spinner txt_type;
    budgetAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__budgets);

        db = new DBHelper(this);

        arrayList = db.readAllBudget();


        Log.i("DB",arrayList.size() + "Size ");

        rv = findViewById(R.id.rview);
        budgetAdapter adapter = new budgetAdapter(arrayList);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);


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
