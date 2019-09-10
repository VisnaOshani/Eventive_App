package com.example.eventive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import DataBase.DBHelper;

public class Budget_Details extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    DBHelper vdb;
    EditText txtnote,txtamount,txtpamount,txtbalance;
    Spinner txttype;

    private String Note;
    private String Type;
    private String Amount;
    private String Pamount;
    private String Balance;
    private String label;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget__details);

        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter =  new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.category_arrays));

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);

        txtnote = findViewById(R.id.nameV);
        txttype = findViewById(R.id.spinner);
        txtamount =findViewById(R.id.estimatedAmount);
        txtpamount = findViewById(R.id.paidAmount);
        txtbalance = findViewById(R.id.balance);

        vdb = new DBHelper(this);

    }

    public void addBudget(View view){
        Note = txtnote.getText().toString();
        Amount = txtamount.getText().toString();
        Pamount = txtpamount.getText().toString();
        Balance = txtbalance.getText().toString();

        boolean result = vdb.addBud(Note,label,Amount,Pamount,Balance);

        txtnote.getText().clear();
        txtamount.getText().clear();
        txtpamount.getText().clear();
        txtbalance.getText().clear();

        if(result == true){
            Toast.makeText(getApplicationContext(),"Success!",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this,Add_Budgets.class);
            startActivity(intent);
        }else{
            Toast.makeText(getApplicationContext(),"Failed!",Toast.LENGTH_LONG).show();
        }
    }

    public void saveBudgets(View view){
        Intent intent = new Intent(Budget_Details.this,Add_Budgets.class);
        startActivity(intent);
    }

    public void backToBudgets(View view){
        Intent intent = new Intent(Budget_Details.this,Add_Budgets.class);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position,
                               long id) {
        // On selecting a spinner item
        label = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
//        Toast.makeText(parent.getContext(), "You selected: " + label,
//                Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}