package com.example.vaith.firstresolver;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ContentResolver contentResolver;
    Uri uri = Uri.parse("content://xyz.vaith.firstprovider/");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contentResolver = getContentResolver();
    }

    public void query(View view)
    {
        Cursor c = contentResolver.query(this.uri, null, "query_where", null, null);
        Toast.makeText(MainActivity.this, "ContentProvider Cursor:" + c, Toast.LENGTH_SHORT).show();
    }

    public void insert(View view)
    {
        ContentValues values = new ContentValues();
        values.put("name","Vaith");
        Uri newUri = contentResolver.insert(uri, values);
        Toast.makeText(MainActivity.this, "ContentProvider Uri:" + newUri, Toast.LENGTH_SHORT).show();
    }

    public void update(View view)
    {
        ContentValues values = new ContentValues();
        values.put("name", "Wee");
        int count = contentResolver.update(uri, values, "update_where", null);
        Toast.makeText(MainActivity.this, "ContentProvider Count: " + count, Toast.LENGTH_SHORT).show();
    }


    public void delete(View view)
    {
        int count = contentResolver.delete(uri, "delete_where", null);
        Toast.makeText(this, "ContentProvider Delete Count: " + count, Toast.LENGTH_SHORT).show();
    }

}
