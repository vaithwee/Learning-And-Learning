package com.example.vaith.attrres;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Vaith on 16/8/19.
 */
public class AlphaImageView extends ImageView
{
    private int alpahDelta = 0;
    private int curAlpha = 0;

    private final int SPEED = 300;
    Handler handler = new Handler()
    {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 0x123)
            {
                curAlpha += alpahDelta;
                if (curAlpha > 255)
                {
                    curAlpha = 255;
                }
                AlphaImageView.this.setAlpha(curAlpha);
            }
        }
    };

    public AlphaImageView(Context context, AttributeSet set)
    {
        super(context,set);
        TypedArray typedArray = context.obtainStyledAttributes(set, R.styleable.AlphaImageView);
        int duration = typedArray.getInt(R.styleable.AlphaImageView_duration, 0);

        TypedArray typedArray1 = context.obtainStyledAttributes(set, R.styleable.ColorImageView);
        int color = typedArray1.getInt(R.styleable.ColorImageView_color, 0);
        Log.d("AlphaImageView", color+" current ");
        alpahDelta = 255 * SPEED / duration;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        this.setImageAlpha(curAlpha);
        super.onDraw(canvas);
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Message message = new Message();
                message.what = 0x123;
                if (curAlpha >= 255)
                {
                    timer.cancel();
                }
                else
                {
                    handler.sendMessage(message);
                }
            }
        }, 0, SPEED);
    }
}
