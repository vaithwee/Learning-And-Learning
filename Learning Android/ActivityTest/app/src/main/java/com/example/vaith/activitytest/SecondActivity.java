package com.example.vaith.activitytest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Vaith on 2016/8/2.
 */
public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(R.layout.second_layout);

        Log.d("SecondActivity", "Task id is " + getTaskId());
//        final Intent intent = getIntent();
//        String data = intent.getStringExtra("hello");
//        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
//        Log.d("SecondActivity", data);


        Button button = (Button) findViewById(R.id.button2);
        assert button != null;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent1 = new Intent();
//                intent1.putExtra("data_return", "Hello FirstActivity");
//                setResult(RESULT_OK, intent1);
//                finish();

                Intent intent1 = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent1);
            }
        });
    }

    @Override
    public void onBackPressed()
    {
        Intent intent1 = new Intent();
        intent1.putExtra("data_return", "Hello FirstActivity");
        setResult(RESULT_OK, intent1);
        finish();
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Log.d("SecondActivity", "onDestroy");
    }
}
