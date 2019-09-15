package com.example.eventive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;

import DataBase.DBHelper;

import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class Add_events extends AppCompatActivity {


        DBHelper Hdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_events);

        ListView evenlist = findViewById(R.id.eventList);
        Hdb = new DBHelper(this);

        ArrayList<String> HList = new ArrayList<>();
        Cursor data = Hdb.getListEvents();

        if (data.getCount() == 0) {

            Toast.makeText(Add_events.this, "event list is empty", Toast.LENGTH_LONG).show();
        }else
            while (data.moveToNext()) {

                HList.add(data.getString(1));
                ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, HList);


                evenlist.setAdapter(listAdapter);
            }
        }


    public void back(View view){
        Intent intent = new Intent(Add_events.this,Home.class);
        startActivity(intent);
    }

    public void addEvents(View view){
        Intent intent = new Intent(Add_events.this,event_details.class);
        startActivity(intent);
    }
}
