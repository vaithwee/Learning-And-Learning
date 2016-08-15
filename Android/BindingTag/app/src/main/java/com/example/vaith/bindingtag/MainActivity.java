package com.example.vaith.bindingtag;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText content;
    Button show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.content = (EditText) findViewById(R.id.content);
        this.show = (Button) findViewById(R.id.show);
    }

    public void show(View view)
    {
        this.content.setText("按钮呗点击了");
    }
}
