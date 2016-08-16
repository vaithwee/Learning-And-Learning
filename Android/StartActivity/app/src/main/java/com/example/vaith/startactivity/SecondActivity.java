package com.example.vaith.startactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Vaith on 16/8/16.
 */
public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(R.layout.activity_second);
        Button pre = (Button) findViewById(R.id.previous);
        Button close = (Button) findViewById(R.id.close);


        assert null != pre;
        pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SecondActivity.this, MainActivity.class));
            }
        });

        assert null != close;
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SecondActivity.this, MainActivity.class));
                finish();
            }
        });
    }
}
