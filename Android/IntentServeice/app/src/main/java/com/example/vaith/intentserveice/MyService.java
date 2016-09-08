package com.example.vaith.intentserveice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.provider.Settings;
import android.support.annotation.Nullable;

/**
 * Created by Vaith on 16/9/8.
 */
public class MyService extends Service
{
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        long endTime = System.currentTimeMillis() + 20 * 1000;
        System.out.println("onStart");
        while (System.currentTimeMillis() < endTime)
        {
            synchronized (this)
            {
                try
                {
                    wait(endTime - System.currentTimeMillis());
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("task complete");
        return START_STICKY;
    }
}
