package com.example.vaith.searchview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SearchView searchView;
    private ListView listView;

    private final String[] mStrings = {"aaaaaa","bbbbb","ccccc"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.listView = (ListView) findViewById(R.id.listView);
        this.searchView = (SearchView) findViewById(R.id.search_view);
        this.listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mStrings));

        this.listView.setTextFilterEnabled(true);


        this.searchView.setIconifiedByDefault(false);
        this.searchView.setSubmitButtonEnabled(true);
        this.searchView.setQueryHint("查找");
        this.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(MainActivity.this, "您的选择是：" + query, Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (TextUtils.isEmpty(newText))
                {
                    listView.clearTextFilter();
                }
                else
                {
                    listView.setFilterText(newText);
                }
                return true;
            }
        });
    }
}
