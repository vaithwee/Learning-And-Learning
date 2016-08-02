package com.example.vaith.activitylifecycletest;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Vaith on 2016/8/2.
 */
public class DialogActivity extends Activity {

    @Override
    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_layout);
    }
}
