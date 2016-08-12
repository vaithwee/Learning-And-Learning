package com.example.vaith.menures;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.textView = (TextView) findViewById(R.id.text_view);
        registerForContextMenu(this.textView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = new MenuInflater(MainActivity.this);
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo info)
    {
        MenuInflater inflater = new MenuInflater(MainActivity.this);
        inflater.inflate(R.menu.context, menu);
        menu.setHeaderIcon(R.mipmap.ic_launcher);
        menu.setHeaderTitle("Choose BackgroundColor");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item)
    {
        item.setChecked(true);
        switch (item.getItemId())
        {
            case R.id.red:
                this.textView.setBackgroundColor(Color.RED);
                break;
            case R.id.green:
                this.textView.setBackgroundColor(Color.GREEN);
                break;
            case R.id.blue:
                this.textView.setBackgroundColor(Color.BLUE);
                break;
        }
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if (item.isCheckable())
        {
            item.setChecked(true);
        }
        switch (item.getItemId())
        {
            case R.id.font_10:
                this.textView.setTextSize(10 *2);
                break;
            case R.id.font_12:
                this.textView.setTextSize(12 *2);
                break;
            case R.id.font_14:
                this.textView.setTextSize(14 *2);
                break;
            case R.id.font_16:
                this.textView.setTextSize(16 *2);
                break;
            case R.id.font_18:
                this.textView.setTextSize(18 *2);
                break;
            case R.id.color_blue:
                this.textView.setTextColor(Color.BLUE);
                break;
            case R.id.color_green:
                this.textView.setTextColor(Color.GREEN);
                break;
            case R.id.color_red:
                this.textView.setTextColor(Color.RED);
                break;
            case R.id.plain_item:
                Toast.makeText(MainActivity.this, "you click normal item", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

}
