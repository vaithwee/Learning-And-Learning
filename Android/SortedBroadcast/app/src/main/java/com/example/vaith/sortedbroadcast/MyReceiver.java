package com.example.vaith.sortedbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by Vaith on 16/9/20.
 */
public class MyReceiver extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "action :" + intent.getAction() + "\nmessage:" + intent.getStringExtra("msg"), Toast.LENGTH_SHORT).show();
        Bundle bundle = new Bundle();
        bundle.putString("first", "第一个BroadcastReceiver 存入的消息");
        setResultExtras(bundle);
    }
}
