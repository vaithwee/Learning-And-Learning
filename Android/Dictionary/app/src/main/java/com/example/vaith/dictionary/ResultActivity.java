package com.example.vaith.dictionary;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.List;
import java.util.Map;

/**
 * Created by Vaith on 16/8/23.
 */
public class ResultActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        ListView listView = (ListView) findViewById(R.id.tableview);
        Intent intent = getIntent();
        Bundle data = intent.getExtras();
        @SuppressWarnings("unchecked")
        List<Map<String, String>> list = (List<Map<String, String>>)data.getSerializable("data");
        SimpleAdapter adapter = new SimpleAdapter(ResultActivity.this, list, R.layout.cell, new String[]{"word", "detail"}, new int[] {R.id.word, R.id.detail});
        listView.setAdapter(adapter);
    }
}
