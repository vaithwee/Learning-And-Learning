package com.example.vaith.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Vaith on 16/8/4.
 */
public class BootCompleteReceiver extends BroadcastReceiver
{
    @Override
    public void onReceive(Context ctx, Intent intent)
    {
        Toast.makeText(ctx, "Boot Complete", Toast.LENGTH_LONG).show();
    }
}
