package com.example.vaith.activitylifecycletest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Vaith on 2016/8/2.
 */
public class NormalActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(R.layout.normal_layout);
    }
}
