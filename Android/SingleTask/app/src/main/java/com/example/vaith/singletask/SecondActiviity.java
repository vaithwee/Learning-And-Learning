package com.example.vaith.singletask;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Vaith on 16/8/17.
 */
public class SecondActiviity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);

        LinearLayout layout = new LinearLayout(this);
        this.setContentView(layout);
        layout.setOrientation(LinearLayout.VERTICAL);

        TextView tv = new TextView(this);
        tv.setText("activity: " + this.toString() + "\n task id: " + this.getTaskId());
        layout.addView(tv);

        Button button = new Button(this);
        button.setText("show single task");
        layout.addView(button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SecondActiviity.this, MainActivity.class));
            }
        });
    }
}
