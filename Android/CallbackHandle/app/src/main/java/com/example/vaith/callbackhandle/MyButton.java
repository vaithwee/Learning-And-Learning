package com.example.vaith.callbackhandle;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Button;

/**
 * Created by Vaith on 16/8/15.
 */
public class MyButton extends Button
{

    public MyButton(Context context, AttributeSet set)
    {
        super(context, set);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        super.onKeyDown(keyCode, event);
        Log.d("MyButton", "the onKeyDown in MyButton");
        return true;
    }

}
