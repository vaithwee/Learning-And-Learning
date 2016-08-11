package com.example.vaith.textswitcher;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {

    TextSwitcher switcher;
    String[] strings = new String[]{
            "Java",
            "Objective-C",
            "Ajax",
            "Swift"
    };

    int curStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.switcher = (TextSwitcher) findViewById(R.id.switcher);
        this.switcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView tv = new TextView(MainActivity.this);
                tv.setTextSize(40);
                tv.setTextColor(Color.MAGENTA);
                return tv;
            }
        });

        next(null);
    }

    public void next(View source)
    {
        this.switcher.setText(strings[curStr++ % strings.length]);
    }
}
