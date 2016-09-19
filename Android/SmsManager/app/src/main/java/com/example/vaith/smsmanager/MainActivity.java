package com.example.vaith.smsmanager;

import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText phone, content;
    Button send;
    SmsManager smsManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        smsManager = SmsManager.getDefault();
        phone = (EditText) findViewById(R.id.phone);
        content = (EditText) findViewById(R.id.content);
        send = (Button) findViewById(R.id.send);
        assert send != null;
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PendingIntent pi = PendingIntent.getActivity(MainActivity.this, 0, new Intent(), 0);
                smsManager.sendTextMessage(phone.getText().toString(), null, content.getText().toString(), pi, null);
                Toast.makeText(MainActivity.this, "send message complete", 8000).show();
            }
        });
    }
}
