package com.example.vaith.actionbar;


import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.actionBar = getSupportActionBar();
    }

    public void show(View view)
    {
        this.actionBar.show();
    }

    public void hide(View view)
    {
        this.actionBar.hide();
    }
}
