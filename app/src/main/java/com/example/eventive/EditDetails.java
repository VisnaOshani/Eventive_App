package com.example.eventive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Type;

import DataBase.DBHelper;

public class EditDetails extends AppCompatActivity {

    DBHelper db;
    EditText txtn,txta,txtp;
    String note,type,amount,pamount;
   Spinner spinner;
    String ID;
    Button updBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_details);

        //update spinner
        Spinner spinner = findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter =  new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.category_arrays));

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Intent intent = getIntent();

        //update other details
        ID = intent.getIntExtra("ID", 0) + "";
        String note = intent.getStringExtra("note");
        String type = intent.getStringExtra("type");
        String amount = intent.getStringExtra("eamount");
        String pamount = intent.getStringExtra("pamount");

        db = new DBHelper(this);

        txtn = findViewById(R.id.editNote);
        spinner = findViewById(R.id.spinner2);
        txta = findViewById(R.id.editAmount2);
        txtp = findViewById(R.id.editPamount);


        txtn.setText(note);
        txta.setText(amount);
        txtp.setText(pamount);
        spinner.setAdapter(adapter);

        int id = SetSpinnerSelection(getResources().getStringArray(R.array.category_arrays),type);
        spinner.setSelection( id );

    }

    //set spinner for update
    public int SetSpinnerSelection(String[] array,String text) {
        for(int i=0;i<array.length;i++) {
            if(array[i].equals(text)) {
                return i;
            }
        }
        return 0;
    }

    public void backToAddBudgets(View view){
        Intent intent = new Intent(EditDetails.this,Add_Budgets.class);
        startActivity(intent);
    }
}
