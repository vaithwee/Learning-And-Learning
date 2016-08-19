package com.example.vaith.intenttab;

import android.app.TabActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tabHost = getTabHost();
        tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("已接电话", getResources().getDrawable(R.mipmap.ic_launcher)).setContent(new Intent(this, BeCalledActivity.class)));
        tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("呼出电话").setContent(new Intent(this, CalledActivity.class)));
        tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("未接来电").setContent(new Intent(this, NoCallActivity.class)));
    }
}
