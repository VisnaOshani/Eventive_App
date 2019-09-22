package com.example.eventive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import DataBase.DBHelper;

public class Event_edit extends AppCompatActivity{

    Button btn,btnlis, laa;



    EditText txt_username, txt_date, loc_txt, not_txt;
    String username, date, loication, notes;
    DBHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_edit);

        btnlis = findViewById(R.id.eventList);

        laa = findViewById(R.id.editbutton);

        txt_username = findViewById(R.id.editone);
        txt_date = findViewById(R.id.edittwo);
        loc_txt = findViewById(R.id.editfive);
        not_txt = findViewById(R.id.editfour);

        db = new DBHelper(this);

        btn = findViewById(R.id.editbtncalander);
        Intent incomingintent = getIntent();
        String date = incomingintent.getStringExtra("date");
        txt_date.setText(date);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Event_edit.this,Calander_view.class);
                startActivity(intent);

            }
        });

        btnlis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Event_edit.this,Add_events.class);
                startActivity(intent);
            }
        });

        laa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Event_edit.this,Add_events.class);
                startActivity(intent);
            }
        });

    }


    //update

    public void viewevents(long id){

        Cursor cursor = db.getErow(id);
        if(cursor.moveToFirst()){

            username = txt_username.toString();
           date = txt_date.toString();
           loication = loc_txt.toString();
            notes = not_txt.toString();


          //  db.updaterowevnt(id,username,date,loication,notes);
        }

        cursor.close();

          }



          public void updatevent(long id){


              Cursor cursor = db.getErow(id);
              if(cursor.moveToFirst()){

                  String username = txt_username.getText().toString();
                  String date = txt_date.getText().toString();
                  String loication = loc_txt.getText().toString();
                  String notes = not_txt.getText().toString();


                  db.updaterowevnt(id,username,date,loication,notes);
              }

              cursor.close();

          }









    }

