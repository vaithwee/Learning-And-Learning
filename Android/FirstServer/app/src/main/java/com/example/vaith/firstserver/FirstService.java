package com.example.vaith.firstserver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by Vaith on 16/9/8.
 */
public class FirstService extends Service
{
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("Service is created");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("Service is started");
        return  START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("Service is destroyed");
    }
}
