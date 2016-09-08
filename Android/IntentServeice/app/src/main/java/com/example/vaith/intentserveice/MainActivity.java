package com.example.vaith.intentserveice;

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

        Button service = (Button) findViewById(R.id.service);
        assert service != null;
        service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MyService.class);
                startService(intent);
            }
        });

        Button intent = (Button) findViewById(R.id.intentservice);
        assert  intent != null;
        intent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this, MyIntentService.class);
                startService(intent1);
            }
        });


    }
}
