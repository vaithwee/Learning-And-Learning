package com.example.vaith.broadcasttest2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Vaith on 16/8/4.
 */
public class AnotheerBroadcasstRecever extends BroadcastReceiver
{
    @Override
    public void onReceive(Context ctx, Intent intent)
    {
        Toast.makeText(ctx, "Received in AnotherBroadcastReceiver", Toast.LENGTH_SHORT).show();
    }
}
