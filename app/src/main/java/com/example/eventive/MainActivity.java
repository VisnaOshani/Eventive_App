package com.example.eventive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import DataBase.DBHelper;
import Models.AddGuest;

public class MainActivity extends AppCompatActivity {

    DBHelper myDb;
    EditText editLname, editFname,people,addressGuest,mobile,email;
    Button btnviewAll;
    Button btnAddData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__guests);
        myDb = new DBHelper(this);


        editFname= (EditText)findViewById(R.id.fNameO);
        editLname=(EditText)findViewById(R.id.lNameO);
        people=(EditText)findViewById(R.id.peopleO);
        addressGuest=(EditText)findViewById(R.id.addGuestO) ;
        mobile=(EditText)findViewById(R.id.mobGuestO);
        email=(EditText)findViewById(R.id.emailGuestO);
        btnAddData = (Button)findViewById(R.id.saveO);
        btnviewAll =(Button)findViewById(R.id.button4);
        //AddData();

    }

    public void login(View view){
        Intent intent = new Intent(MainActivity.this,Add_Guests.class);
        startActivity(intent);
    }

    public void goToHome(View view){
        Intent intent = new Intent(MainActivity.this,Home.class);
        startActivity(intent);
    }

//    public void AddData(){
//        btnAddData.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//                        public void onClick(View v){
//                         boolean isInserted = myDb.addGuest(editFname.getText().toString(),editLname.getText().toString(),people.getText().toString(),addressGuest.getText().toString()),mobile,getText().toString(),email.getText().toString())
  //                      if(isInserted = true)
//                            Toast.makeTest(MainActivity.this, "Data Saved", Toast.Length_Long).show_guests();
//                        else
//                                Toast.makeTest(MainActivity.this, "Data not Saved", Toast.Length_Long).show_guests();
//                        }
//                    }
//                }
//
//
//    }
//    public void viewAll(){
//        btnviewAll.setOnContextClickListener();
//
//    }
}
