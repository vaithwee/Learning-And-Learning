package com.example.vaith.launchservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Vaith on 16/9/22.
 */

public class LaunchReceiver extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent intent1 = new Intent(context, LaunchService.class);
        context.startService(intent1);
    }
}
