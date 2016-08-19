package com.example.vaith.valuesres;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int[] textIds = new int[]{
            R.string.c1,
            R.string.c2,
            R.string.c3,
            R.string.c4,
            R.string.c5,
            R.string.c6,
            R.string.c7,
            R.string.c8,
            R.string.c9
    };

    int[] colorIds = new int[]{
            R.color.c1,
            R.color.c2,
            R.color.c3,
            R.color.c4,
            R.color.c5,
            R.color.c6,
            R.color.c7,
            R.color.c8,
            R.color.c9
    };

    String[] texts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.texts = getResources().getStringArray(R.array.string_arr);

        BaseAdapter adapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return texts.length;
            }

            @Override
            public Object getItem(int i) {
                return texts[i];
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                TextView text = new TextView(MainActivity.this);
                Resources res = MainActivity.this.getResources();
                text.setWidth((int)res.getDimension(R.dimen.cell_width));
                text.setHeight((int)res.getDimension(R.dimen.cell_height));
                text.setText(texts[i]);
                TypedArray colors = res.obtainTypedArray(R.array.plain_arr);
                text.setBackground(colors.getDrawable(i));
                text.setTextSize(20);
                return text;
            }
        };
        GridView gridView = (GridView) findViewById(R.id.grid);
        gridView.setAdapter(adapter);
    }
}
