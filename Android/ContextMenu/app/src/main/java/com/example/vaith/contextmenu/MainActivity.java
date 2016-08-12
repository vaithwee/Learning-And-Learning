package com.example.vaith.contextmenu;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final int MENU1 = 0x111;
    final int MENU2 = 0x222;
    final int MENU3 = 0x333;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.text = (TextView) findViewById(R.id.text_view);
        registerForContextMenu(this.text);
    }

    @Override
    public void onCreateContextMenu(ContextMenu contextMenu, View source, ContextMenu.ContextMenuInfo menuInfo)
    {
        contextMenu.add(0, MENU1, 0, "红色");
        contextMenu.add(0, MENU2, 0, "绿色");
        contextMenu.add(0, MENU3, 0, "蓝色");
        contextMenu.setGroupCheckable(0, true, true);
        contextMenu.setHeaderIcon(R.mipmap.ic_launcher);
        contextMenu.setHeaderTitle("选择背景色");

    }

    @Override
    public boolean onContextItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case MENU1:
                item.setChecked(true);
                this.text.setBackgroundColor(Color.RED);
                break;
            case MENU2:
                item.setChecked(true);
                this.text.setBackgroundColor(Color.GREEN);
                break;
            case MENU3:
                item.setChecked(true);
                this.text.setBackgroundColor(Color.BLUE);
                break;
        }
        return true;
    }
}
