package com.example.eventive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.CalendarView;

public class Calander_view extends AppCompatActivity {

    private CalendarView mcalander;
    private static final String TAG = "Calander_view";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calander_view);
        mcalander = (CalendarView) findViewById(R.id.calendarView);

        mcalander.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int i, int i1, int i2) {
                String date = i + "/" +i1 + "/" +i2;
                Log.d(TAG, "onSelectedDayChange: mm/dd/yyyy: " + date);


                Intent intent = new Intent(Calander_view.this, event_details.class);
                intent.putExtra("date", date);
                startActivity(intent);
            }
        });


    }
}
