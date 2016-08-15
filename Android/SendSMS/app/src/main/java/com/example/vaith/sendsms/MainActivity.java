package com.example.vaith.sendsms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText address;
    EditText content;
    Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.address = (EditText) findViewById(R.id.address);
        this.content = (EditText) findViewById(R.id.content);
        this.send = (Button) findViewById(R.id.send);
        this.send.setOnLongClickListener(new SendSmsListener(this, this.address, this.content));

    }
}
