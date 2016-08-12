package com.example.vaith.popupmenu;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    PopupMenu popupMenu;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.button = (Button) findViewById(R.id.show);
    }

    public void show(View view)
    {
        this.popupMenu = new  PopupMenu(MainActivity.this, view);
        getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                popupMenu.dismiss();
                switch (item.getItemId())
                {
                    case R.id.blue:
                        button.setBackgroundColor(Color.BLUE);
                        break;
                    case R.id.green:
                        button.setBackgroundColor(Color.GREEN);
                        break;
                    case R.id.red:
                        button.setBackgroundColor(Color.RED);
                        break;
                }
                return true;
            }
        });
        this.popupMenu.show();
    }
}
