package com.example.vaith.activitymenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        SubMenu prog = menu.addSubMenu("启动程序");
        MenuItem item = prog.add("Swift");
        item.setIntent(new Intent(MainActivity.this, OtherActivity.class));
        return super.onCreateOptionsMenu(menu);
    }
}
