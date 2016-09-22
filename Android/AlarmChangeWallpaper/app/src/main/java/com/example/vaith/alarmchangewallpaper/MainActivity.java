package com.example.vaith.alarmchangewallpaper;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button start, stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = (Button) findViewById(R.id.start);
        stop = (Button) findViewById(R.id.stop);

        Intent intent = new Intent(MainActivity.this, ChangeService.class);
        final PendingIntent pi = PendingIntent.getService(MainActivity.this, 0, intent, 0);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlarmManager aManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                aManager.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, 0, 5000, pi);
                start.setEnabled(false);
                stop.setEnabled(true);
                Toast.makeText(MainActivity.this, "wallpaper change start", Toast.LENGTH_SHORT).show();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                start.setEnabled(true);
                stop.setEnabled(false);
                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                alarmManager.cancel(pi);
            }
        });
    }
}
