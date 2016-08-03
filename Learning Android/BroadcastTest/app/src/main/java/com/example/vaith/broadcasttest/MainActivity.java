package com.example.vaith.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private IntentFilter intentFilter;
    private NetworkChangeReceiver networkChangeReceiver;


    /*创建*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        networkChangeReceiver = new NetworkChangeReceiver();
        registerReceiver(networkChangeReceiver, intentFilter);
    }


    /*销毁*/
    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        /*试图销毁时取消广播*/
        unregisterReceiver(networkChangeReceiver);
    }

}

class NetworkChangeReceiver extends BroadcastReceiver
{
    /*接收通知后*/
    @Override
    public void onReceive(Context ctx, Intent intent)
    {
        Toast.makeText(ctx, "netword change", Toast.LENGTH_SHORT).show();
    }

}
