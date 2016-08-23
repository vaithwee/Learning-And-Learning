package com.example.vaith.gesturezoom;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener
{

    GestureDetector detector;
    ImageView imageView;
    Bitmap bitmap;
    int width, height;
    float currentScale = 1;
    Matrix matrix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        detector = new GestureDetector(this, this);
        imageView = (ImageView)findViewById(R.id.content);
        matrix = new Matrix();
        bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.sky);
        width = bitmap.getWidth();
        height = bitmap.getHeight();
        imageView.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.sky));

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return detector.onTouchEvent(event);
    }

    @
}
