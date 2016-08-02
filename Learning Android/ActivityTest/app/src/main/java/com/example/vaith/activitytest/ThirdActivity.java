package com.example.vaith.activitytest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by Vaith on 2016/8/2.
 */
public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(R.layout.third_layout);

        Log.d("ThirdActivity", "Task id is " + getTaskId());
    }
}
