package com.example.eventive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class Budget_Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget__details);

        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter =  new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.category_arrays));

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public void saveBudgets(View view){
        Intent intent = new Intent(Budget_Details.this,Add_Budgets.class);
        startActivity(intent);
    }

    public void backToBudgets(View view){
        Intent intent = new Intent(Budget_Details.this,Add_Budgets.class);
        startActivity(intent);
    }
}





