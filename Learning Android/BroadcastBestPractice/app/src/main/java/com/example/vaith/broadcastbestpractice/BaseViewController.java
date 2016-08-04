package com.example.vaith.broadcastbestpractice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Vaith on 16/8/4.
 */
public class BaseViewController extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        NavigationController.pushViewController(this);
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        NavigationController.popViewController(this);
    }

}
