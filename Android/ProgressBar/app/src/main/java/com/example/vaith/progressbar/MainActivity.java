package com.example.vaith.progressbar;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private int[] data = new int[100];
    int hasData = 0;
    int status = 0;
    ProgressBar bar, bar2;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg)
        {
            if (msg.what == 0x111)
            {
                bar.setProgress(status);
                bar2.setProgress(status);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.bar = (ProgressBar) findViewById(R.id.bar);
        this.bar2 = (ProgressBar) findViewById(R.id.bar2);

        new Thread(){
            public void run()
            {
                while (status < 100)
                {
                    status = doWork();
                    handler.sendEmptyMessage(0x111);
                }
            }
        }.start();
    }

    public int doWork()
    {
        data[hasData++] = (int)(Math.random()*100);
        try {
                Thread.sleep(100);
            }
        catch (InterruptedException e)
        {
            e.printStackTrace();;
        }
        finally {
            return hasData;
        }
    }
}
