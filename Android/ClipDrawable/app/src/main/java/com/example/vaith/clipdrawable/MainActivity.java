package com.example.vaith.clipdrawable;

import android.graphics.drawable.ClipDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = (ImageView)findViewById(R.id.image);
        final ClipDrawable clipDrawable = (ClipDrawable) imageView.getDrawable();
        final Handler handler = new Handler()
        {
            @Override
            public void handleMessage(Message msg) {
                if (msg.what == 0x1233)
                {
                    Log.d("ClipDrawable Level :" ," "+ clipDrawable.getLevel());
                    clipDrawable.setLevel(clipDrawable.getLevel()+1000);
                }
            }
        };

        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Message msg = new Message();
                msg.what = 0x1233;
                handler.sendMessage(msg);
                Log.d("ClipDrawable Level :" ," "+ clipDrawable.getLevel());
                if (clipDrawable.getLevel() >= 10000)
                {
                    timer.cancel();
                }
            }
        }, 0, 300);
    }
}
