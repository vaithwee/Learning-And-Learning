package com.example.vaith.simpleadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    private String[] names = new String[]{
            "James", "Tom", "Jane", "Newbee"
    };

    private String[] descs = new String[]{
            "Software Engieer",
            "Act",
            "Author",
            "Game Master"
    };

    private int[] images = new int[]{
      R.drawable.sky1,
            R.drawable.sky2,
            R.drawable.sky3,
            R.drawable.sky4
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < names.length; ++i)
        {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", images[i]);
            map.put("name", names[i]);
            map.put("desc", descs[i]);
            mapList.add(map);
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(this,
                mapList,
                R.layout.simple_item,
                new String[] {"name", "image", "desc"},
                new int[] {R.id.name, R.id.image, R.id.desc});

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(simpleAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("MainActivity", "Click" + names[i]);
            }
        });

        listView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("MainActitivity", "Selected " + names[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
