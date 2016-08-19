package com.example.vaith.actioncateattr;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Set;

/**
 * Created by Vaith on 16/8/18.
 */
public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView textView = (TextView) findViewById(R.id.textview);
        String action = getIntent().getAction();
        Set<String> category = getIntent().getCategories();
        textView.setText("Action:" + action + "Category:" + category);
    }
}
