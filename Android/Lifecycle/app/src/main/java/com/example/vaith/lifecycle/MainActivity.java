package com.example.vaith.lifecycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    final String TAG = "Life Cycle";
    Button show, close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "---------onCreate----------");
        this.close = (Button) findViewById(R.id.close);
        this.show = (Button) findViewById(R.id.show);
        this.show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        this.close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.finish();
            }
        });
    }

    @Override
    public void onStart()
    {
        super.onStart();
        Log.d(TAG, "---------onStart----------");
    }

    @Override
    public void onRestart()
    {
        super.onRestart();
        Log.d(TAG, "---------onRestart----------");
    }

    @Override
    public void onResume()
    {
        super.onResume();
        Log.d(TAG,"---------onResume----------");
    }

    @Override
    public void onPause()
    {
        super.onPause();
        Log.d(TAG, "---------onPause----------");
    }

    @Override
    public void onStop()
    {
        super.onStop();
        Log.d(TAG, "---------onStop----------");
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        Log.d(TAG, "---------onDestroy----------");
    }

}
