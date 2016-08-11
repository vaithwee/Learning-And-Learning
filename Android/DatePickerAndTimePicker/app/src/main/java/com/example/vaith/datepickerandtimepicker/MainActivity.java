package com.example.vaith.datepickerandtimepicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatePicker datePicker = (DatePicker) findViewById(R.id.date_picker);
        TimePicker timePicker = (TimePicker) findViewById(R.id.time_picker);

        Calendar calendar = Calendar.getInstance();
        this.year = calendar.get(Calendar.YEAR);
        this.month = calendar.get(Calendar.MONTH);
        this.day = calendar.get(Calendar.DAY_OF_MONTH);
        this.hour = calendar.get(Calendar.HOUR);
        this.minute = calendar.get(Calendar.MINUTE);


        assert datePicker != null;
        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int year, int month, int day) {

                MainActivity.this.year = year;
                MainActivity.this.month = month;
                MainActivity.this.day = day;
                showDate(year, month, day, hour, minute);
            }
        });

        assert timePicker != null;
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int hour, int min) {
                MainActivity.this.hour = hour;
                MainActivity.this.minute = min;
                showDate(year, month, day, hour, min);
            }
        });

    }


    private void showDate(int year, int month, int day, int hour, int minute) {
        EditText show = (EditText) findViewById(R.id.show);
        show.setText("您购买的日期为：" + year + "年" + month + "月" + day + "日" + " " + hour + "时" + minute + "分");
    }

}
