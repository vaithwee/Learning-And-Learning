package com.example.vaith.progressbardialog;

import android.app.ProgressDialog;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void showNormal(View view)
    {
        ProgressDialog.show(this, "任务执行中", "任务执行中，请等待", false, true);
    }


    ProgressDialog progressDialog1;
    public void showIndeterminate(View view)
    {
        progressDialog1 = new ProgressDialog(MainActivity.this);
        progressDialog1.setTitle("任务执行中");
        progressDialog1.setMessage("任务正在执行中，敬请等待...");
        progressDialog1.setCancelable(true);
        progressDialog1.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog1.setIndeterminate(true);
        progressDialog1.show();
    }

    ProgressDialog progressDialog;
    final static int MAX_PROGRESS = 100;
    private int[] data = new int[50];
    int progressStatus = 0;
    int hasData = 0;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg)
        {
            if (msg.what == 0x123)
            {
                progressDialog.setProgress(progressStatus);
            }
        }
    };
    public void showProgress(View view)
    {
        progressStatus = 0;
        hasData = 0;
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMax(MAX_PROGRESS);
        progressDialog.setTitle("任务完成百分比");
        progressDialog.setMessage("耗时任务的完成百分比");
        progressDialog.setCancelable(false);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setIndeterminate(false);
        progressDialog.show();
        new Thread()
        {
          public void run()
          {
              while (progressStatus < MAX_PROGRESS)
              {
                  progressStatus = MAX_PROGRESS * doWork() / data.length;
                  handler.sendEmptyMessage(0x123);
              }
              if (progressStatus >= MAX_PROGRESS)
              {
                  progressDialog.dismiss();
              }
          }

        }.start();
    }

    public int doWork()
    {
        data[hasData++] = (int) (Math.random() * 100);
        try {
            Thread.sleep(100);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        finally {

        }
        return hasData;
    }


}
