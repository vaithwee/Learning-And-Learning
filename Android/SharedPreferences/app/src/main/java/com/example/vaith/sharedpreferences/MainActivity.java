package com.example.vaith.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getSharedPreferences("vaith", MODE_PRIVATE);
        editor = preferences.edit();

        Button read = (Button) findViewById(R.id.read);
        Button write = (Button) findViewById(R.id.write);

        assert  read != null;
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String time = preferences.getString("time", null);
                int randNum = preferences.getInt("random", 0);
                String result = time == null?"您暂时还未写入数据":"写入时间为:"+time+"\n上次生成的随机数为："+randNum;
                Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
            }
        });

        assert write != null;
        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                editor.putString("time", sdf.format(new Date()));
                editor.putInt("random", (int)(Math.random()*100));
                editor.commit();
            }
        });
    }
}
