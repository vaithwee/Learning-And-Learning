package com.example.vaith.simpleadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    private String[] names = new String[]{
            "James", "Tom", "Jane", "Newbee"
    };

    private String[] descs = new String[]{
            "Software Engieer",
            "Act"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
