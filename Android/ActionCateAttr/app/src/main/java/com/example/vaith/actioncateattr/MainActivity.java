package com.example.vaith.actioncateattr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    final  static String ACTION = "xyz.vaith.actioncateattr.mainaction";
    final static String CATEGORY = "xyz.vaith.actioncateattr.maincategory";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.show);
        assert button != null;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(ACTION);
                intent.addCategory(CATEGORY);
                startActivity(intent);
            }
        });
    }
}
