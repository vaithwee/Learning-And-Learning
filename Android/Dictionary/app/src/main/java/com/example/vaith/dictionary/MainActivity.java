package com.example.vaith.dictionary;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    MyDatabaseHelper databaseHelper;
    Button add = null;
    Button search = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new MyDatabaseHelper(this, "myDict.db3", 1);
        this.add = (Button) findViewById(R.id.add);
        this.search = (Button) findViewById(R.id.search);
        this.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String word = ((EditText) findViewById(R.id.word)).getText().toString();
                String detail = ((EditText) findViewById(R.id.detail)).getText().toString();
                insertData(databaseHelper.getWritableDatabase(), word, detail);
                Toast.makeText(MainActivity.this, "Add Successfully", Toast.LENGTH_SHORT).show();
            }
        });


        this.search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String key = ((EditText)findViewById(R.id.keyword)).getText().toString();
                Cursor cursor = databaseHelper.getReadableDatabase().rawQuery("select * from dict where word like ? or detail like ?", new String[] {"%"+key+"%", "%"+key+"%"});
                Bundle data = new Bundle();
                data.putSerializable("data", converCursorToLost(cursor));
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtras(data);
                startActivity(intent);
            }
        });

    }

    public void insertData(SQLiteDatabase database, String word, String detail)
    {
        database.execSQL("insert into dict values(null, ?, ?)", new String[] {word, detail});
    }

    protected ArrayList<Map<String, String>> converCursorToLost(Cursor cursor)
    {
        ArrayList<Map<String, String>> result = new ArrayList<Map<String, String>>();
        while (cursor.moveToNext())
        {
            Map<String, String> map = new HashMap<>();
            map.put("word", cursor.getString(1));
            map.put("detail", cursor.getString(2));
            result.add(map);
        }
        return result;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (databaseHelper != null)
        {
            databaseHelper.close();
        }
    }
}
