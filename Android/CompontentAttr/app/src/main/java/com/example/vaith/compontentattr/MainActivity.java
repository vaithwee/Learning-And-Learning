package com.example.vaith.compontentattr;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.show);
        assert button != null;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ComponentName comp = new ComponentName(MainActivity.this, SecondActitvity.class);
                Intent intent = new Intent();
                intent.setComponent(comp);
                startActivity(intent);
            }
        });

    }
}
