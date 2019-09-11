package com.example.eventive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Add_events extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_events);
    }

    public void back(View view){
        Intent intent = new Intent(Add_events.this,Home.class);
        startActivity(intent);
    }


    public void addevents(View view){
        Intent intent = new Intent(Add_events.this,activity_event_details.class);
        startActivity(intent);
    }


}
