package com.example.vaith.firstserver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    static Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.intent = new Intent(this, FirstService.class);

    }

    public void startService(View view)
    {
        startService(intent);
    }

    public void stopService(View view)
    {
        stopService(intent);
    }

}
