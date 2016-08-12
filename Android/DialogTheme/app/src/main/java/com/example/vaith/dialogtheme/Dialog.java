package com.example.vaith.dialogtheme;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Vaith on 16/8/12.
 */
public class Dialog extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(R.layout.dialog);
    }

    public void sure(View view)
    {
        finish();
    }
}
