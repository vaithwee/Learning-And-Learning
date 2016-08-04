package com.example.vaith.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private IntentFilter intentFilter;
    private NetworkChangeReceiver networkChangeReceiver;

    private LocalReceiver localReceiver;
    private LocalBroadcastManager localBroadcastManager;

    /*创建*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        intentFilter = new IntentFilter();
//        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
//        networkChangeReceiver = new NetworkChangeReceiver();
//        registerReceiver(networkChangeReceiver, intentFilter);

//        Button send = (Button) findViewById(R.id.send);
//        send.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent("com.example.vaith.broadcasttest.MY_BROADCAST");
//                sendOrderedBroadcast(intent, null);
//            }
//        });


        /*获取本地广播示例*/
        localBroadcastManager = LocalBroadcastManager.getInstance(this);

        Button send = (Button) findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.example.broadcasttest.LOCAL_BROADCAST");
                localBroadcastManager.sendBroadcast(intent);
            }
        });

        intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.broadcasttest.LOCAL_BROADCAST");
        localReceiver = new LocalReceiver();
        localBroadcastManager.registerReceiver(localReceiver, intentFilter);

    }


    /*销毁*/
    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        /*试图销毁时取消广播*/
//        unregisterReceiver(networkChangeReceiver);
        localBroadcastManager.unregisterReceiver(localReceiver);
    }

}

class NetworkChangeReceiver extends BroadcastReceiver
{
    /*接收通知后*/
    @Override
    public void onReceive(Context ctx, Intent intent)
    {

        /*网络连接管理*/
        ConnectivityManager connectivityManager = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);

        /*获取网络连接状态, 需要添加权限， ACCESS_NETWORK_STATE*/
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isAvailable())
        {
            Toast.makeText(ctx, "network is available", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(ctx, "network is unavaialbe", Toast.LENGTH_SHORT).show();
        }


    }

}

class LocalReceiver extends BroadcastReceiver
{
    @Override
    public void onReceive(Context ctx, Intent intent)
    {
        Toast.makeText(ctx, "Received local broadcast", Toast.LENGTH_SHORT).show();
    }
}
