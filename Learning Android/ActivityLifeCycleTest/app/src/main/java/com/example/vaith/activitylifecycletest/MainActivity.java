package com.example.vaith.activitylifecycletest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate");

        Button normal = (Button) findViewById(R.id.normalbutton);
        Button diglog = (Button) findViewById(R.id.dialogbutton);
        normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NormalActivity.class);
                startActivity(intent);
            }
        });

        diglog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DialogActivity.class);
                startActivity(intent);
            }
        });

        if (bundle != null)
        {
            String data = bundle.getString("data_key");
            Log.d(TAG, data);
        }
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause()
    {
        super.onPause();;
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    protected void onRestart()
    {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    @Override
    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        String data = "Something you just typed";
        bundle.putString("data_key", data);
    }

}

