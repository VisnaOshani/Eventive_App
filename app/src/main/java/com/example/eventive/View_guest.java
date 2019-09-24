package com.example.eventive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import DataBase.DatabaseHelper;

public class View_guest extends AppCompatActivity {


    private EditText fname, lname, people, guestaddress, mobileno, email;
    String nameF, nameL, peopleG, addressG, mobileG, emailG;
    Button update, delete, view;
    DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_guest);
        db = new DatabaseHelper(this);

        fname = findViewById(R.id.fNameO2);
        lname = findViewById(R.id.lNameO2);
        people = findViewById(R.id.peopleO2);
        guestaddress = findViewById(R.id.addGuestO2);
        mobileno = findViewById(R.id.mobGuestO2);
        email = findViewById(R.id.emailGuestO2);

        Intent intent = getIntent();

        nameF = intent.getStringExtra(Add_Guests.FName);
        nameL = intent.getStringExtra(Add_Guests.LName);
        peopleG = intent.getStringExtra(Add_Guests.NoOGuests);
        addressG = intent.getStringExtra(Add_Guests.address);
        mobileG = intent.getStringExtra(Add_Guests.mobNo);
        emailG = intent.getStringExtra(Add_Guests.emaillG);

        fname.setText(nameF);
        lname.setText(nameL);
        people.setText(peopleG);
        guestaddress.setText(addressG);
        mobileno.setText(mobileG);
        email.setText(emailG);

    }

    public void main(View view) {
        Intent intent = new Intent(this, Add_Guests.class);
        startActivity(intent);
    }

    public void update(View view) {
        Boolean isUpdated = db.updateData(fname.getText().toString(), lname.getText().toString(), Integer.parseInt(people.getText().toString()), guestaddress.getText().toString(), Integer.parseInt(mobileno.getText().toString()), email.getText().toString());

        if (isUpdated == true) {
            Toast.makeText(getApplicationContext(), "Updated successfully", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Error in updating", Toast.LENGTH_SHORT).show();
        }
    }

    //delete method
    public void delete(View view){
        Integer deletedRows = db.deleteData(email.getText().toString());

        if (deletedRows != 0){
            Toast.makeText(getApplicationContext(),"Deleted successfully",Toast.LENGTH_SHORT).show();

            fname.setText("");
            lname.setText("");
            people.setText("");
            guestaddress.setText("");
            mobileno.setText("");
            email.setText("");

            Intent intent = new Intent(this, Add_Guests.class);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(),"Error in deleting",Toast.LENGTH_SHORT).show();
        }
    }
}
