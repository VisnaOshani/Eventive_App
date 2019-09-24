package com.example.eventive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Adapters.guestAdapter;
import DataBase.DBHelper;
import DataBase.DatabaseHelper;

public class Add_Guests extends AppCompatActivity {

    DatabaseHelper db;

    public static final String FName = "fName";
    public static final String LName = "lName";
    public static final String NoOGuests = "people";
    public static final String address = "guestAddress";
    public static final String mobNo ="mobileNo";
    public static final String emaillG = "email";

    private EditText fname,lname,people,guestaddress,mobileno, email;
    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__guests);

        db = new DatabaseHelper(this);

        fname=findViewById(R.id.fNameO);
        lname=findViewById(R.id.lNameO);
        people=findViewById(R.id.peopleO);
        guestaddress=findViewById(R.id.addGuestO);
        mobileno=findViewById(R.id.mobGuestO);
        email =findViewById(R.id.emailGuestO);

        save = findViewById(R.id.saveO);

    }

    public void save(View view){

        String namef = fname.getText().toString();
        String nameL = lname.getText().toString();
        String guestCount = people.getText().toString();
        String addressG = guestaddress.getText().toString();
        String mobG = mobileno.getText().toString();
        String emailG = email.getText().toString();

        if(namef.equals("") || nameL.equals("")|| guestCount.equals("")|| addressG.equals("")|| mobG.equals("")|| emailG.equals("") ){
            Toast.makeText(getApplicationContext(),"Fields are empty",Toast.LENGTH_SHORT).show();
        }else {
            Boolean insert = db.insertGuest(namef, nameL, Integer.parseInt(guestCount), addressG, Integer.parseInt(mobG), emailG);
            if (insert == true) {
                Toast.makeText(getApplicationContext(), "Data inserted successfully", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Not inserted", Toast.LENGTH_SHORT).show();
            }

            Intent intent= new Intent(this,View_guest.class);

            intent.putExtra(FName,namef);
            intent.putExtra(LName,nameL);
            intent.putExtra(NoOGuests,guestCount);
            intent.putExtra(address,addressG);
            intent.putExtra(mobNo,mobG);
            intent.putExtra(emaillG,emailG);

            startActivity(intent);
        }

    }
}
