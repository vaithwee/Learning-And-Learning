package com.example.vaith.baseadapter;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);

        BaseAdapter adapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return  40;
            }

            @Override
            public Object getItem(int i) {
                return null;
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                LinearLayout linearLayout = new LinearLayout(MainActivity.this);
                linearLayout.setOrientation(0);
                ImageView imageView = new ImageView(MainActivity.this);
                imageView.setImageResource(R.mipmap.ic_launcher);
                TextView textView = new TextView(MainActivity.this);
                textView.setText("No." + (i+1) + " item");
                textView.setTextSize(20);
                textView.setTextColor(Color.RED);
                linearLayout.addView(imageView);
                linearLayout.addView(textView);
                return linearLayout;
            }
        };

        listView.setAdapter(adapter);
    }
}
