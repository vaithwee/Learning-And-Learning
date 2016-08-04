package com.example.vaith.broadcastbestpractice;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vaith on 16/8/4.
 */
public class NavigationController
{
    public static List<AppCompatActivity> viewControllers = new ArrayList<AppCompatActivity>();

    public static void pushViewController(AppCompatActivity activity)
    {
        viewControllers.add(activity);
    }

    public static void popViewController(AppCompatActivity activity)
    {
        viewControllers.remove(activity);
    }

    public static void finishAll()
    {
        for (Activity activity:viewControllers)
        {
            activity.finish();
        }
    }
}
