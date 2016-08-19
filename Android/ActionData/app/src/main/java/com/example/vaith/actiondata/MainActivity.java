package com.example.vaith.actiondata;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toView(View view)
    {
        Intent intent = new Intent();
        String data = "http://www.baidu.com";
        Uri uri = Uri.parse(data);
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(uri);
        startActivity(intent);
    }

    public void toContact(View view)
    {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_EDIT);
        String data = "content://com.android.contacts/contacts/1";
        Uri uri = Uri.parse(data);
        intent.setData(uri);
        startActivity(intent);
    }

    public void toCall(View view)
    {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_DIAL);
        String  data = "tel:18650476660";
        Uri uri = Uri.parse(data);
        intent.setData(uri);
        startActivity(intent);
    }
}
