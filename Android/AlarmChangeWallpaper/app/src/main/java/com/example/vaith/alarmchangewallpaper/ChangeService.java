package com.example.vaith.alarmchangewallpaper;

import android.app.Service;
import android.app.WallpaperManager;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by Vaith on 16/9/22.
 */

public class ChangeService extends Service
{
    int[] wallpapers = new int[]{
        R.drawable.ajax,
            R.drawable.html,
            R.drawable.java,
            R.drawable.swift
    };

    WallpaperManager wManager;
    int current = 0;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (current >= 4)
        {
            current = 0;
        }
        try {
            wManager.setResource(wallpapers[current++]);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return START_STICKY;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        wManager = WallpaperManager.getInstance(this);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
