package com.example.vaith.stackview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SimpleAdapter;
import android.widget.StackView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    StackView stackView;
    int[] images = new int[]{
            R.drawable.sky,
            R.drawable.sky1,
            R.drawable.sky2,
            R.drawable.sky3,
            R.drawable.sky4,
            R.drawable.sky5

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.stackView = (StackView) findViewById(R.id.mStackView);
        List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < images.length; ++i)
        {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", images[i]);
            mapList.add(map);

        }

        SimpleAdapter adapter = new SimpleAdapter(this, mapList, R.layout.cell, new String[]{ "image"}, new int[]{R.id.image_view});
        this.stackView.setAdapter(adapter);
    }

    public void prev(View view)
    {
        this.stackView.showPrevious();
    }

    public void next(View view)
    {
        this.stackView.showNext();
    }
}
