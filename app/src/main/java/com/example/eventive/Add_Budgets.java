package com.example.eventive;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import Adapters.budgetAdapter;
import DataBase.DBHelper;
import Models.Fbudget;

public class Add_Budgets extends AppCompatActivity implements budgetAdapter.OnBudgetListener {

    private ArrayList<Fbudget> arrayList;
    DBHelper db;
    RecyclerView rv;
    budgetAdapter adapter;
    Fbudget r;
    String ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__budgets);

        //search part
        EditText editText = findViewById(R.id.editTextV);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                filter(editable.toString());
            }
        });

        db = new DBHelper(this);

        arrayList = db.readAllBudget();
        Log.i("DB",arrayList.size() + "Size ");

        rv = findViewById(R.id.rviewv);
        adapter = new budgetAdapter(arrayList,this);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);

        new ItemTouchHelper(itemTouchHelprcallback).attachToRecyclerView(rv);

    }
    //search
    private void filter(String text){
        ArrayList<Fbudget> filteredList = new ArrayList<>();

        for (Fbudget item : arrayList) {
            if (item.getType().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
            }
        }

        adapter.filterList(filteredList);
    }

    public void add(View view){
        Intent in = new Intent(Add_Budgets.this, Budget_Details.class);
        startActivity(in);
    }

    public void back(View view){
        Intent intent = new Intent(Add_Budgets.this,Home.class);
        startActivity(intent);
    }
    //delete
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

    //view layout
    @Override
    public void onBudgetClick(int position) {
        r = arrayList.get(position);
        Intent intent = new Intent(this,EditDetails.class);
        intent.putExtra("ID", r.getID()+"");
        ID = String.valueOf(r.getID());
        Log.i("ID in Budget act: ", ID);
        intent.putExtra("note", r.getNote());
        intent.putExtra("type", r.getType());
        intent.putExtra("eamount", r.getAmount());
        intent.putExtra("pamount",r.getPamount());
        intent.putExtra("balance", r.getBalance());
        startActivity(intent);
    }
}
