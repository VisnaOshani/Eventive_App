package com.example.eventive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;


import DataBase.DBHelper;

public class event_details extends AppCompatActivity {

    private static final String TAG = "event_details";

    Button btn;

    EditText txt_username, txt_date, loc_txt, not_txt;
    String username, date, loication, notes;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);



        txt_username = findViewById(R.id.one);
        txt_date = findViewById(R.id.two);
        loc_txt = findViewById(R.id.five);
        not_txt = findViewById(R.id.four);

        db = new DBHelper(this);

        btn = findViewById(R.id.btncalander);
        Intent incomingintent = getIntent();
        String date = incomingintent.getStringExtra("date");
        txt_date.setText(date);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               Intent intent = new Intent(event_details.this,Calander_view.class);
                startActivity(intent);

            }
        });

    }

    public void addInfro(View view) {

        username = txt_username.getText().toString();
        date = txt_date.getText().toString();
        loication = loc_txt.getText().toString();
        notes = not_txt.getText().toString();

        boolean result = db.addUser(username,date,loication,notes);

        if (result == true) {

            Toast.makeText(getApplicationContext(), "event added", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this,Add_events.class);
            startActivity(intent);
        } else {

            Toast.makeText(getApplicationContext(), "Error in adding ", Toast.LENGTH_LONG).show();
        }
    }
}





