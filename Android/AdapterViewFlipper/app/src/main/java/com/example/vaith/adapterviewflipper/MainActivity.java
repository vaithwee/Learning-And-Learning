package com.example.vaith.adapterviewflipper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    int[] images = new int[]{
            R.drawable.sky,
            R.drawable.sky1,
            R.drawable.sky2,
            R.drawable.sky3,
            R.drawable.sky4,
            R.drawable.sky5,
    };


    private AdapterViewFlipper flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.flipper = (AdapterViewFlipper) findViewById(R.id.flipper);
        BaseAdapter adapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return images.length;
            }

            @Override
            public Object getItem(int i) {
                return i;
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                ImageView imageView = new ImageView(MainActivity.this);
                imageView.setImageResource(images[i]);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                return imageView;
            }
        };
        flipper.setAdapter(adapter);
    }

    public void prev(View source)
    {
        flipper.showPrevious();
        flipper.stopFlipping();
    }
    public void next(View source)
    {
        flipper.showNext();
        flipper.stopFlipping();
    }

    public void auto(View source)
    {
        flipper.startFlipping();
    }
}
