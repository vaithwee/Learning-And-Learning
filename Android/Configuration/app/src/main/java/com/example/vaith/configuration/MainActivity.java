package com.example.vaith.configuration;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText ori;
    EditText navigation;
    EditText touch;
    EditText mnc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ori = (EditText) findViewById(R.id.ori);
        navigation = (EditText) findViewById(R.id.navigation);
        touch = (EditText) findViewById(R.id.touch);
        mnc = (EditText) findViewById(R.id.mnc);

        Button show = (Button) findViewById(R.id.show);
        assert show != null;
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Configuration cgf = getResources().getConfiguration();
                String screen = cgf.orientation == Configuration.ORIENTATION_LANDSCAPE ? "横向屏幕" : "竖向屏幕";
                String mncCode = cgf.mnc + "";
                String naviName = cgf.orientation == Configuration.NAVIGATION_NONAV ? "没有方向控制" :
                        cgf.orientation == Configuration.NAVIGATION_WHEEL ? "轮滚控制方向" :
                                cgf.orientation == Configuration.NAVIGATION_DPAD ? "方向键控制" : "轨迹球控制方向";
                navigation.setText(naviName);
                String touchName = cgf.touchscreen == Configuration.TOUCHSCREEN_NOTOUCH?"无触摸屏":"支持触摸屏";
                ori.setText(screen);
                mnc.setText(mncCode);
                touch.setText(touchName);
            }
        });
    }
}
