package com.example.vaith.menu;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final int FONT_10 = 0x111;
    final int FONT_12 = 0x222;
    final int FONT_14 = 0x333;
    final int FONT_16 = 0x444;
    final int FONT_18 = 0x555;


    final int PLAIN_ITEM = 0x11b;
    final int FONT_RED = 0x116;
    final int FONT_BLUE = 0x117;
    final int FONT_GREEN = 0x118;

    private EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit = (EditText) findViewById(R.id.text_view);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        SubMenu fontMenu = menu.addSubMenu("字体大小");
        fontMenu.setIcon(R.mipmap.ic_launcher);

        fontMenu.setHeaderIcon(R.mipmap.ic_launcher);
        fontMenu.setHeaderTitle("选择字体大小");
        fontMenu.add(0, FONT_10, 0, "10号字体");
        fontMenu.add(0, FONT_12, 0, "12号字体");
        fontMenu.add(0, FONT_14, 0, "14号字体");
        fontMenu.add(0, FONT_16, 0, "16号字体");
        fontMenu.add(0, FONT_18, 0, "18号字体");

        menu.add(0, PLAIN_ITEM, 0, "普通菜单项");
        SubMenu color = menu.addSubMenu("字体颜色");
        color.setIcon(R.mipmap.ic_launcher);
        color.setHeaderIcon(R.mipmap.ic_launcher);
        color.setHeaderTitle("选择文字颜色");
        color.add(0, FONT_RED, 0, "红色");
        color.add(0, FONT_BLUE, 0, "蓝色");
        color.add(0, FONT_GREEN, 0, "绿色");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem)
    {
        switch (menuItem.getItemId())
        {
            case FONT_10:
                edit.setTextSize(10 *2);
                break;
            case FONT_12:
                edit.setTextSize(12 * 2);
                break;
            case FONT_14:
                edit.setTextSize(14 * 2);
                break;
            case FONT_16:
                edit.setTextSize(16 * 2 );
                break;
            case FONT_18:
                edit.setTextSize(18*2);
                break;
            case FONT_RED:
                edit.setTextColor(Color.RED);
                break;
            case FONT_BLUE:
                edit.setTextColor(Color.BLUE);
                break;
            case FONT_GREEN:
                edit.setTextColor(Color.GREEN);
                break;
            case PLAIN_ITEM:
                Toast.makeText(MainActivity.this, "您选择了普通菜单", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }
}
