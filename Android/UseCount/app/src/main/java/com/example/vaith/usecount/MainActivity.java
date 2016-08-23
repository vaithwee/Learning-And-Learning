package com.example.vaith.usecount;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getSharedPreferences("count", MODE_PRIVATE);

        int count = preferences.getInt("count", 0);
        Toast.makeText(MainActivity.this, "程序以前被使用了"+count+"次", Toast.LENGTH_LONG).show();

        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("count", ++count);
        editor.commit();
    }
}
