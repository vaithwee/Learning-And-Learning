package com.example.vaith.quickcontactbadge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.QuickContactBadge;

public class MainActivity extends AppCompatActivity {


    QuickContactBadge badge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        badge = (QuickContactBadge) findViewById(R.id.badge);
        badge.assignContactFromEmail("1-865-047-6660", false);
    }
}
