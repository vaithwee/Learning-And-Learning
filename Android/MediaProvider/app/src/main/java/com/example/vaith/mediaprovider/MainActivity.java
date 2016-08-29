package com.example.vaith.mediaprovider;

import android.content.ContentValues;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {


    ArrayList<String> names = new ArrayList<>();
    ArrayList<String> descs = new ArrayList<>();
    ArrayList<String> fileNames = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button search = (Button)findViewById(R.id.search);
        assert search != null;
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                names.clear();
                descs.clear();
                fileNames.clear();
                Cursor cursor = getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, null, null, null);
                while (cursor.moveToNext() && names.size() < 10)
                {
                    String name = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DISPLAY_NAME));
                    String desc = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DESCRIPTION));
                    byte[] data = cursor.getBlob(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
                    names.add(name);
                    descs.add(desc);
                    fileNames.add(new String(data, 0, data.length -1));

                }

                List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
                for (int i = 0; i < names.size(); ++i)
                {
                    Map<String, Object> listItem = new HashMap<String, Object>();
                    listItem.put("name", names.get(i));
                    listItem.put("desc", names.get(i));
                    listItems.add(listItem);
                }

                SimpleAdapter adapter = new SimpleAdapter(MainActivity.this, listItems,R.layout.line, new String[] {"name", "desc"}, new int[] {R.id.name, R.id.desc});
                ListView listView = (ListView) findViewById(R.id.list);
                listView.setAdapter(adapter);
            }
        });

        ListView listView = (ListView) findViewById(R.id.list);
        assert listView != null;
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                View layout = getLayoutInflater().inflate(R.layout.view, null);
                ImageView imageView = (ImageView)layout.findViewById(R.id.imageview1);
                imageView.setImageBitmap(BitmapFactory.decodeFile(fileNames.get(i)));
                new AlertDialog.Builder(MainActivity.this).setView(layout).setPositiveButton("sure", null).show();
            }
        });

        Button add = (Button) findViewById(R.id.add);
        assert  add != null;
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues values = new ContentValues();
                values.put(MediaStore.Images.Media.DISPLAY_NAME, "金塔");
                values.put(MediaStore.Images.Media.DESCRIPTION, "jintta");
                values.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg");
                Uri uri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
                Bitmap bitmap = BitmapFactory.decodeResource(MainActivity.this.getResources(), R.mipmap.ic_launcher);
                OutputStream os = null;
                try
                {
                    os = getContentResolver().openOutputStream(uri);
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, os);
                    os.close();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        });
    }
}
