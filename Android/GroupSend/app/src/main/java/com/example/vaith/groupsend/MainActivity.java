package com.example.vaith.groupsend;

import android.app.PendingIntent;
import android.content.Intent;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import android.Manifest;

public class MainActivity extends AppCompatActivity {

    EditText phone, content;
    Button selected, send;
    SmsManager smsManager;
    ArrayList<String> sendList = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.SEND_SMS}, 1);


        smsManager = SmsManager.getDefault();
        phone = (EditText) findViewById(R.id.phone);
        content = (EditText) findViewById(R.id.content);
        selected = (Button) findViewById(R.id.select);
        send = (Button) findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (String number : sendList)
                {
                    PendingIntent pi = PendingIntent.getActivity(MainActivity.this, 0, new Intent(), 0);
                    smsManager.sendTextMessage(number, number, content.getText().toString(), pi, null);

                }
                Toast.makeText(MainActivity.this, "send message successful");
            }
        });

        selected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Cursor cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
                BaseAdapter adapter = new BaseAdapter() {
                    @Override
                    public int getCount() {
                        return cursor.getCount();
                    }

                    @Override
                    public Object getItem(int i) {
                        return i;
                    }

                    @Override
                    public long getItemId(int i) {
                        return i;
                    }

                    @Override
                    public View getView(int i, View view, ViewGroup viewGroup) {
                        cursor.moveToPosition(i);
                        CheckBox rb = new CheckBox(MainActivity.this);
                        String number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)).replace("-", "").replace(" ", "");
                        rb.setText(number);
                        if (isChecked(number))
                        {
                            rb.setChecked(true);
                        }
                        return rb;
                    }
                };

//                View selectView = getLayoutInflater().inflate()
            }
        });



    }

    public boolean isChecked(String phone)
    {
        for (String s1 : sendList)
        {
            if (s1.equals(phone))
            {
                return true;
            }
        }
        return false;
    }
}
