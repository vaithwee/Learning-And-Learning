package com.example.vaith.listactivity;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        String[] arr = {"Java", "php", "swfit", "node.js"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.support.v7.appcompat.R.layout.abc_list_menu_item_checkbox, arr);
        setListAdapter(adapter);
    }
}
