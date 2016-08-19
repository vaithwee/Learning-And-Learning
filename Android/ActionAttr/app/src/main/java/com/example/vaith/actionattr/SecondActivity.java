package com.example.vaith.actionattr;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Vaith on 16/8/18.
 */
public class SecondActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView tv = (TextView) findViewById(R.id.textview);
        String action = getIntent().getAction();
        tv.setText(action);
    }
}
