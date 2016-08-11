package com.example.vaith.toast;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toast(View view)
    {
        Toast.makeText(MainActivity.this, "Simple tip ",Toast.LENGTH_SHORT).show();
    }

    public void toastWithImage(View view)
    {
        Toast toast = new Toast(MainActivity.this);
        toast.setGravity(Gravity.CENTER, 0, 0);
        ImageView image = new ImageView(MainActivity.this);
        image.setImageResource(R.mipmap.ic_launcher);
        LinearLayout layout = new LinearLayout(MainActivity.this);
        layout.addView(image);
        TextView tv = new TextView(MainActivity.this);
        tv.setText("toast with image and text");
        tv.setTextSize(24);
        tv.setTextColor(Color.MAGENTA);
        layout.addView(tv);
        toast.setView(layout);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.show();
    }
}
