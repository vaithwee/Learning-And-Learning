package com.example.vaith.singleinstance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        this.setContentView(layout);

        TextView tv = new TextView(this);
        tv.setText("Activity: " + this.toString() + "\n Task ID: " + this.getTaskId());
        layout.addView(tv);

        Button button = new Button(this);
        button.setText("Start SecondActivity");
        layout.addView(button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });

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
