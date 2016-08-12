package com.example.vaith.plainview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by Vaith on 16/8/12.
 */
public class PlainView extends View
{
    public float currentX;
    public float currentY;
    Bitmap plane;
    public PlainView(Context context)
    {
        super(context);
        plane = BitmapFactory.decodeResource(context.getResources(), R.drawable.plane);
        setFocusable(true);
    }

    @Override
    public void onDraw(Canvas canvas)
    {
        Paint p = new Paint();
        canvas.drawBitmap(plane, currentX, currentY, p);
    }
}
