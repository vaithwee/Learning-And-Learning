package com.example.vaith.monitersms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

/**
 * Created by Vaith on 16/9/22.
 */

public class SmsReceiver extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED"))
        {
            abortBroadcast();
            StringBuilder sb = new StringBuilder();
            Bundle bundle = intent.getExtras();
            if (bundle != null)
            {
                Object[] pdus = (Object[]) bundle.get("pdus");
                SmsMessage[] messages = new SmsMessage[pdus.length];
                for (int i = 0; i < pdus.length; ++i)
                {
                    messages[i] = SmsMessage.createFromPdu((byte[])pdus[i]);
                }
                for (SmsMessage message: messages)
                {
                    sb.append("短信来源:");
                    sb.append(message.getDisplayOriginatingAddress());
                    sb.append("\n短信内容:");
                    sb.append(message.getDisplayMessageBody());
                }
            }
            Toast.makeText(context, sb.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
