package com.example.vaith.calendarview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    CalendarView cv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.cv = (CalendarView) findViewById(R.id.calendarView);
        this.cv.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int i, int i1, int i2) {
                Toast.makeText(MainActivity.this, "Your birthday is " + i + "year " + i1 + "month" + i2 + "day", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
