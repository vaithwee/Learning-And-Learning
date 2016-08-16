package com.example.vaith.bundle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Vaith on 16/8/16.
 */
public class ResultAcitivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(R.layout.activity_result);

        TextView name = (TextView) findViewById(R.id.name);
        TextView passowrd = (TextView) findViewById(R.id.password);
        TextView gender = (TextView) findViewById(R.id.gender);

        Intent intent = getIntent();
        Person p = (Person) intent.getSerializableExtra("person");
        name.setText("您的用户名为:" + p.name);
        passowrd.setText("您的密码为：" + p.password);
        gender.setText("您的性别为：" + p.gender);
    }

}
