package com.example.eventive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
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
    private double bal;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget__details);

        Spinner spinner = findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter =  new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.category_arrays));

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);

        txtnote = findViewById(R.id.nameV);
        txttype = findViewById(R.id.spinner2);
        txtamount =findViewById(R.id.estimatedAmount);
        txtpamount = findViewById(R.id.paidAmount);
        txtbalance = findViewById(R.id.balance);


        vdb = new DBHelper(this);

        Amount = txtamount.getText().toString();
        Pamount = txtpamount.getText().toString();

        txtpamount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() != 0){
                    if( txtamount.getText().toString().length() > 0  ){
                        bal = Double.valueOf(txtamount.getText().toString() ) - Double.valueOf( txtpamount.getText().toString());
                        txtbalance.setText( bal+"");
                    }
                }else{
                    txtbalance.setText( "");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {


            }
        });
    }

    public void addBudget(View view){

        if (TextUtils.isEmpty(txtnote.getText())|| TextUtils.isEmpty(txtamount.getText()) || TextUtils.isEmpty(txtpamount.getText() )){
            txtnote.setError("Enter your note!");
            txtamount.setError("Enter estimated amount!");
            txtpamount.setError("Enter paid amount!");

            txtnote.requestFocus();
            txtamount.requestFocus();
            txtpamount.requestFocus();
        }
        else {
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