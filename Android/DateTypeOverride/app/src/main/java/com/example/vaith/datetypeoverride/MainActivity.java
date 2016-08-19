package com.example.vaith.datetypeoverride;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void setType(View view)
    {
        Intent intent = new Intent();

        intent.setData(Uri.parse("vaith://www.vaith.xyz/test"));
        intent.setType("abc/xyz");
        Toast.makeText(this, intent.toString(), Toast.LENGTH_SHORT).show();
    }

    public void setData(View view)
    {
        Intent intent = new Intent();
        intent.setType("abc/xyz");
        intent.setData(Uri.parse("vaith://www.vaith.xyz/mypaht"));
        Toast.makeText(this, intent.toString(), Toast.LENGTH_SHORT).show();
    }

    public void setDataAndType(View view)
    {
        Intent intent = new Intent();
        intent.setDataAndType(Uri.parse("vaith://www.vaith.xyz/dataandtype"), "abc/xyz");
        Toast.makeText(this, intent.toString(), Toast.LENGTH_SHORT).show();
    }
}
