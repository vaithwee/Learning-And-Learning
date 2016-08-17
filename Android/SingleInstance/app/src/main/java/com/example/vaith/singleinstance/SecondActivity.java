package com.example.vaith.singleinstance;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Vaith on 16/8/17.
 */
public class SecondActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);

        LinearLayout layout = new LinearLayout(this);
        setContentView(layout);

        TextView tv = new TextView(this);
        tv.setText("hello this is second");
        layout.addView(tv);

        Button button1 = new Button(this);
        button1.setText("隐式启动");
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction("com.example.vaith.aciton.SECOND");
                startActivity(intent);
            }
        });
        layout.addView(button1);
    }
}
