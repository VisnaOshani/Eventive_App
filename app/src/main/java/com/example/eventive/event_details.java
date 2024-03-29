package com.example.eventive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.ListView;
import android.widget.Toast;


import java.sql.Time;

import DataBase.DBHelper;

public class event_details extends AppCompatActivity {

    private static final String TAG = "event_details";

    Button btn,btnlis;



    EditText txt_username, txt_date, loc_txt, not_txt;
    String username, date, loication, notes;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        btnlis = findViewById(R.id.eventLis);

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

       btnlis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(event_details.this,Add_events.class);
                startActivity(intent);
            }
        });

    }

    public void addInfro(View view) {

        if(TextUtils.isEmpty(txt_username.getText())|| TextUtils.isEmpty(txt_date.getText()) || TextUtils.isEmpty(loc_txt.getText() )) {

            txt_username.setError("Enter Event name!");
            txt_date.setError("Enter Date");
            loc_txt.setError("Enter location");

            txt_username.requestFocus();
            txt_date.requestFocus();
            loc_txt.requestFocus();

        }
        else{
            username = txt_username.getText().toString();
            date = txt_date.getText().toString();
            loication = loc_txt.getText().toString();
            notes = not_txt.getText().toString();


            boolean result = db.addUser(username, date, loication, notes);

            if (result == true) {

                Toast.makeText(getApplicationContext(), "event added", Toast.LENGTH_LONG).show();

            } else {

                Toast.makeText(getApplicationContext(), "Error in adding ", Toast.LENGTH_LONG).show();
            }

        }
    }





    public void back(View view){
        Intent intent = new Intent(event_details.this,Add_events.class);
        startActivity(intent);
    }


}





