package com.example.vaith.activitytest;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Vaith on 16/8/2.
 */
public class FirstActivity extends AppCompatActivity {
    //创建
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);

        Log.d("FirstActivity", "Task id is " + getTaskId());
        Log.d("FirstActivity", this.toString());
        Button button1 = (Button) findViewById(R.id.button1);
        assert button1 != null;
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Toast.makeText(FirstActivity.this, "You click Button 1", Toast.LENGTH_SHORT).show();

                //Intent intent = new Intent(FirstActivity.this, SecondActivity.class);

//                Intent intent = new Intent("com.example.vaith.activitytest.ACTION_START");
//                intent.addCategory("com.example.vaith.activitytest.MY_CATEGORY");
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse("http://www.baidu.com"));

//                String data = "Hello SecondActivity";
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
//                intent.putExtra("hello", data);

                startActivity(intent);
//                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        switch (requestCode)
        {
            case 1:
                if (resultCode == RESULT_OK)
                {
                    String returndata = data.getStringExtra("data_return");
                    Log.d("FirstActivity", returndata);
                    Toast.makeText(this, returndata, Toast.LENGTH_SHORT).show();
                }
                break;
            default:
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.add_item:
                Toast.makeText(this, "You clicked add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "You clicked remove", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

    @Override
    protected void onRestart()
    {
        super.onRestart();
        Log.d("FirstActivity", "onRestart");
    }
}
