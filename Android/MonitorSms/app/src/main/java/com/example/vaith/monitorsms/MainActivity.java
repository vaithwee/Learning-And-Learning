package com.example.vaith.monitorsms;

import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getContentResolver().registerContentObserver(Uri.parse("content://sms"), true, new SmsObserver(new Handler()));
    }

    private final class SmsObserver extends ContentObserver
    {
        public SmsObserver(Handler handler)
        {
            super(handler);
        }

        @Override
        public void onChange(boolean selfChange) {
            Cursor cursor = getContentResolver().query(Uri.parse("content://sms/outbox"), null, null, null, null);
            while (cursor.moveToNext())
            {
                StringBuilder sb = new StringBuilder();
                sb.append("address=").append(cursor.getString(cursor.getColumnIndex("address")));
                sb.append("subject=").append(cursor.getString(cursor.getColumnIndex("subject")));
                sb.append("body=").append(cursor.getString(cursor.getColumnIndex("body")));
                sb.append("time=").append(cursor.getLong(cursor.getColumnIndex("date")));
                System.out.println("send message:" + sb.toString());
            }
        }
    }
}
