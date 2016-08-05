package com.example.vaith.notificationtest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button sendNotice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendNotice = (Button) findViewById(R.id.send_notice);
        assert sendNotice != null;
        sendNotice.setOnClickListener(this);

    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.send_notice:
            {

                Intent intent = new Intent(this, NotificationActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);

                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                Notification notification = new Notification.Builder(this).
                        setContentIntent(pendingIntent).
                        setContentTitle("title").
                        setContentText("content").
                        setSmallIcon(R.drawable.chat).
                        setTicker("your get a new message").
                        setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher)).
                        setSound(Uri.fromFile(new File("/system/media/audio/ringtones/Basic_tone.ogg"))).
                        build();
                manager.notify(1, notification);

                break;
            }
            default:
                break;
        }
    }
}
