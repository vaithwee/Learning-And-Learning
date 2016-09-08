package com.example.vaith.bindservice;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button bind, unbind, count;
    BindService.MyBinder binder;
    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            System.out.println("Server connection");
            binder = (BindService.MyBinder)iBinder;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            System.out.println("server disconnection");
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bind = (Button) findViewById(R.id.bind);
        unbind = (Button) findViewById(R.id.unbind);
        count = (Button) findViewById(R.id.count);
        final Intent intent = new Intent(this, BindService.class);
        bind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bindService(intent, conn, BIND_AUTO_CREATE);
            }
        });


        unbind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                unbindService(conn);
            }
        });

        count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Server's count is " + binder.getCount(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
