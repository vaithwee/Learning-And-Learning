package com.example.vaith.intenttab;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

/**
 * Created by Vaith on 16/8/18.
 */
public class NoCallActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout layout = new LinearLayout(this);
        layout.setBackgroundColor(Color.GREEN);
        setContentView(layout);
    }
}
