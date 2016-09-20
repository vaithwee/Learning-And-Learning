package com.example.vaith.sortedbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by Vaith on 16/9/20.
 */
public class MyReceiver2 extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = getResultExtras(true);
        String first = bundle.getString("first");
        Toast.makeText(context, "first receiver message:" + first, Toast.LENGTH_SHORT).show();
    }
}
