package com.example.vaith.gridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    ImageView imageView;
    int[] images = new int[]{
            R.drawable.sky, R.drawable.sky1, R.drawable.sky2, R.drawable.sky3, R.drawable.sky4, R.drawable.sky5,
            R.drawable.sky, R.drawable.sky1, R.drawable.sky2, R.drawable.sky3, R.drawable.sky4, R.drawable.sky5,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>() ;
        for (int i = 0; i <images.length; ++i)
        {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", images[i]);
            mapList.add(map);
        }


        this.imageView = (ImageView) findViewById(R.id.imageView);
        this.gridView = (GridView) findViewById(R.id.gridView);


        SimpleAdapter adapter = new SimpleAdapter(this, mapList, R.layout.cell, new String[] {"image"}, new int[] {R.id.image_cell});
        this.gridView.setAdapter(adapter);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                imageView.setImageResource(images[i]);
            }
        });

    }
}
