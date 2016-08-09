package com.example.vaith.togglebutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    ToggleButton  toggleButton;
    Switch aSwitch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleButton = (ToggleButton) findViewById(R.id.toggle);
        aSwitch = (Switch) findViewById(R.id.switcher);
        final LinearLayout root = (LinearLayout) findViewById(R.id.line_layout);

        CompoundButton.OnCheckedChangeListener listener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                {
                    root.setOrientation(1);
                    toggleButton.setChecked(true);
                    aSwitch.setChecked(true);
                }
                else
                {
                    root.setOrientation(0);
                    toggleButton.setChecked(false);
                    aSwitch.setChecked(false);
                }
            }
        };
        toggleButton.setOnCheckedChangeListener(listener);
        aSwitch.setOnCheckedChangeListener(listener);
    }
}
