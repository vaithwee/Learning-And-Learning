package com.example.vaith.activitylistener;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText content;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.content = (EditText) findViewById(R.id.content);
        this.send = (Button) findViewById(R.id.send);

        this.send.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        this.content.setText("Button按钮被点击了");
    }
}
