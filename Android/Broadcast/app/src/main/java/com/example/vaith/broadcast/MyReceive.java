package com.example.vaith.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Vaith on 16/9/20.
 */
public class MyReceive extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "action: " + intent.getAction().toString() + "\nmessage:" + intent.getStringExtra("msg"), Toast.LENGTH_SHORT).show();
    }
}
