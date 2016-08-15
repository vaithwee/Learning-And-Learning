package com.example.vaith.anonymouslistener;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText content;
    Button show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.content = (EditText)findViewById(R.id.content);
        this.show = (Button) findViewById(R.id.show);

        this.show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                content.setText("Button被点击了");
            }
        });
    }
}
