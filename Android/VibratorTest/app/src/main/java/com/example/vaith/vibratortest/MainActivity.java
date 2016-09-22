package com.example.vaith.vibratortest;

import android.app.Service;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Vibrator vibrator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vibrator = (Vibrator) getSystemService(Service.VIBRATOR_SERVICE);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Toast.makeText(this, "phone is vibrating", Toast.LENGTH_SHORT).show();
        vibrator.vibrate(2000);
        return super.onTouchEvent(event);
    }
}
