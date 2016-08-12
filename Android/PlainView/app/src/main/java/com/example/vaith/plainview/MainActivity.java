package com.example.vaith.plainview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    private int speed = 10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        final  PlainView plainView = new PlainView(this);
        setContentView(plainView);
        plainView.setBackgroundColor(Color.GREEN);
        WindowManager manager = getWindowManager();
        Display display = manager.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        plainView.currentX = metrics.widthPixels / 2;
        plainView.currentY = metrics.heightPixels - 40;

        plainView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                switch (keyEvent.getKeyCode())
                {
                    case KeyEvent.KEYCODE_S:
                        plainView.currentY += speed;
                        break;
                    case KeyEvent.KEYCODE_W:
                        plainView.currentY -= speed;
                        break;
                    case KeyEvent.KEYCODE_A:
                        plainView.currentX -= speed;
                        break;
                    case KeyEvent.KEYCODE_D:
                        plainView.currentX += speed;
                        break;
                }
                plainView.invalidate();
                return true;
            }
        });
    }
}
