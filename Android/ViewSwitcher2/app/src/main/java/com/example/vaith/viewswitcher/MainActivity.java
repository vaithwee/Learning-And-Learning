package com.example.vaith.viewswitcher;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;
import android.widget.ViewSwitcher;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final int NUMBER_PER_SCREEN = 12;
    public static class DataItem
    {
        public String dataName;
        public Drawable drawable;
    }

    private ArrayList<DataItem> items = new ArrayList<DataItem>();

    private int screenNo = 1;
    private int screenCount;
    ViewSwitcher viewSwitcher;

    LayoutInflater layoutInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layoutInflater = LayoutInflater.from(MainActivity.this);
        for (int i = 0; i < 40; ++i)
        {
            String label = "" + 1;
            Drawable drawable = getResources().getDrawable(R.mipmap.ic_launcher);
            DataItem item = new DataItem();
            item.dataName = label;
            item.drawable = drawable;
            items.add(item);
        }

        screenCount = items.size() % NUMBER_PER_SCREEN == 0?
                items.size()/NUMBER_PER_SCREEN:
                items.size()/NUMBER_PER_SCREEN + 1;

        viewSwitcher = (ViewSwitcher) findViewById(R.id.viewSwitcher);
        viewSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                return layoutInflater.inflate(R.layout.slidelistview, null);
            }
        });
        next(null);
    }

    public void next(View v)
    {
        if (screenNo < screenCount -1)
        {
            screenNo++;
            viewSwitcher.setInAnimation(this, R.anim.slide_in_right);
            viewSwitcher.setOutAnimation(this, R.anim.slide_out_left);
            ((GridView) viewSwitcher.getNextView()).setAdapter(adapter);
            viewSwitcher.showNext();
        }
    }

}
