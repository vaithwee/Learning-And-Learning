package com.example.vaith.handler;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    int[] images = new int[]{
            R.drawable.ajax,
            R.drawable.html,
            R.drawable.java,
            R.drawable.swift
    };

    int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView imageView = (ImageView) findViewById(R.id.show);
        final Handler myHandler = new Handler() {
            @Override
            public void handleMessage(Message message) {
                if (message.what == 0x1233) {
                    imageView.setImageResource(images[currentIndex++ % images.length]);
                }
            }
        };

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                myHandler.sendEmptyMessage(0x1233);
            }
        }, 0, 1200);

    }
}
