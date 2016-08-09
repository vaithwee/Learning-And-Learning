package com.example.vaith.imageview;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    int[] images = new int[]{
            R.drawable.sky,
            R.drawable.sky1,
            R.drawable.sky2,
            R.drawable.sky3,
            R.drawable.sky4,
            R.drawable.sky5

    };

    int currentImage = 0;
    private int alpha = 255;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Button add = (Button) findViewById(R.id.add);
        final Button reduce = (Button) findViewById(R.id.reduce);
        Button next = (Button) findViewById(R.id.next);
        final ImageView bigImage = (ImageView) findViewById(R.id.image1);
        final ImageView smallImage = (ImageView) findViewById(R.id.image2);

        assert next != null;
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bigImage.setImageResource(images[++currentImage%images.length]);
            }
        });

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view == add)
                {
                    alpha += 20;
                }
                if (view == reduce)
                {
                    alpha -= 20;
                }
                if (alpha >= 255)
                {
                    alpha = 255;
                }
                if (alpha <=0)
                {
                    alpha = 0;
                }
                assert smallImage != null;
                smallImage.setImageAlpha(alpha);
            }
        };

        assert add != null;
        assert reduce != null;
        add.setOnClickListener(listener);
        reduce.setOnClickListener(listener);

        assert bigImage != null;
        bigImage.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) bigImage.getDrawable();
                Bitmap bitmap = bitmapDrawable.getBitmap();
                double scale = 1.0 *bitmap.getHeight()/bigImage.getHeight();
                int x = (int)(motionEvent.getX() *scale);
                int y = (int)(motionEvent.getY() * scale);
                if (x + 120 > bitmap.getWidth())
                {
                    x = bitmap.getWidth()-120;
                }
                if (y + 120 > bitmap.getHeight())
                {
                    y = bitmap.getHeight() - 120;
                }
                smallImage.setImageBitmap(Bitmap.createBitmap(bitmap, x,y ,120, 120));
                smallImage.setImageAlpha(alpha);
                return false;
            }
        });
    }
}
