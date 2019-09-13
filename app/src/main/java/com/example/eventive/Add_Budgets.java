package com.example.eventive;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

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

        new ItemTouchHelper(itemTouchHelprcallback).attachToRecyclerView(rv);






    }

    public void addBudgets(View view){
        Intent intent = new Intent(Add_Budgets.this,Budget_Details.class);
        startActivity(intent);
    }

    public void back(View view){
        Intent intent = new Intent(Add_Budgets.this,Home.class);
        startActivity(intent);
    }

    ItemTouchHelper.SimpleCallback itemTouchHelprcallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            int deleteid = arrayList.get(viewHolder.getAdapterPosition()).getID();
            db.deleteRead(deleteid);
            Toast.makeText(getApplicationContext(),"Deleted!",Toast.LENGTH_LONG).show();
        }
    };
}
