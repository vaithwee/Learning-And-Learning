package com.example.vaith.sendsms;

import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Vaith on 16/8/15.
 */
public class SendSmsListener implements View.OnLongClickListener
{
    private AppCompatActivity activity;
    private EditText address;
    private EditText content;
    public SendSmsListener(AppCompatActivity activity, EditText address, EditText content)
    {
        this.activity = activity;
        this.address = address;
        this.content = content;
    }

    @Override
    public boolean onLongClick(View source)
    {
        String addressStr = this.address.getText().toString();
        String contentStr = this.content.getText().toString();

//        SmsManager smsManager = SmsManager.getDefault();
//        PendingIntent sendIntent = PendingIntent.getBroadcast(this.activity, 0, new Intent(), 0);
//        smsManager.sendTextMessage(addressStr, null, contentStr, sendIntent, null);
        Toast.makeText(this.activity, "短信发送完成", Toast.LENGTH_SHORT).show();
        return false;
    }
}
