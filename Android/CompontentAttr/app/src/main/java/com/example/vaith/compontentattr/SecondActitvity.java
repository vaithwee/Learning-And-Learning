package com.example.vaith.compontentattr;

import android.content.ComponentName;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Vaith on 16/8/18.
 */
public class SecondActitvity extends AppCompatActivity
{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView tv = (TextView) findViewById(R.id.textview);
        ComponentName comp = getIntent().getComponent();
        tv.setText("组件包名为：" + comp.getPackageName() + "组件类名为：" + comp.getClassName());
    }
}
