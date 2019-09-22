package com.example.eventive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
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
    EditText txtn,txta,txtp , txtb;
    String note,type,amount,pamount , balance , ID;
    Spinner spinner;
     ArrayAdapter<String> adapter;
    Button updBtn;
    double bal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_details);

        //update spinner
         spinner = findViewById(R.id.spinner2);
        adapter =  new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.category_arrays));

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Intent intent = getIntent();

        //update other details
        ID = intent.getStringExtra("ID");
        Log.i("DB", "I got the ID : " + ID);
          note = intent.getStringExtra("note");
          type = intent.getStringExtra("type");
         amount = intent.getStringExtra("eamount");
        pamount = intent.getStringExtra("pamount");
        balance = intent.getStringExtra("balance");

        db = new DBHelper(this);

        txtn = findViewById(R.id.editNote);
        spinner = findViewById(R.id.spinner2);
        txta = findViewById(R.id.editAmount2);
        txtp = findViewById(R.id.editPamount);
        txtb = findViewById(R.id.balance);

        txtb.setText(balance);
        txtn.setText(note);
        txta.setText(amount);
        txtp.setText(pamount);
        spinner.setAdapter(adapter);

        updBtn = findViewById(R.id.editBtn);

        updBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                note = txtn.getText().toString().trim();
                amount = txta.getText().toString().trim();
                pamount = txtp.getText().toString().trim();
                balance = txtb.getText().toString().trim();
                type =  adapter.getItem(spinner.getSelectedItemPosition() );

                boolean ret = db.editBudget( ID, note, amount, type, pamount , balance );

                if (ret == true){
                    Toast.makeText(getApplicationContext(),"Updated",Toast.LENGTH_LONG).show();
                    Intent in = new Intent(EditDetails.this,Add_Budgets.class);
                    startActivity(in);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Update Failed",Toast.LENGTH_LONG).show();
                }

            }
        });

        int id = SetSpinnerSelection(getResources().getStringArray(R.array.category_arrays),type);
        spinner.setSelection( id );

        txta.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() != 0){
                    if( txtp.getText().toString().length() > 0  ){
                        bal = Double.valueOf(txta.getText().toString() ) - Double.valueOf( txtp.getText().toString());
                        txtb.setText( bal+"");
                    }
                }else{
                    txtb.setText( "");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {


            }
        });

        txtp.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() != 0){
                    if( txta.getText().toString().length() > 0  ){
                        bal = Double.valueOf(txta.getText().toString() ) - Double.valueOf( txtp.getText().toString());
                        txtb.setText( bal+"");
                    }
                }else{
                    txtb.setText( "");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {


            }
        });

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
