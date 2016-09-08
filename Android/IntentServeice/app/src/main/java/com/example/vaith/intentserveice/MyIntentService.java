package com.example.vaith.intentserveice;

import android.app.IntentService;
import android.content.Intent;

/**
 * Created by Vaith on 16/9/8.
 */
public class MyIntentService extends IntentService
{
    public MyIntentService()
    {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
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
    }
}
