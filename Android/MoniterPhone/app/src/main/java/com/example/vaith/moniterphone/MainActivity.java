package com.example.vaith.moniterphone;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;

import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.sql.Date;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TelephonyManager tManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        PhoneStateListener listener = new PhoneStateListener()
        {
            @Override
            public void onCallStateChanged(int state, String incomingNumber) {
                switch (state)
                {
                    case TelephonyManager.CALL_STATE_IDLE:
                        break;
                    case TelephonyManager.CALL_STATE_OFFHOOK:
                        break;
                    case TelephonyManager.CALL_STATE_RINGING:
                    {
                        OutputStream os = null;
                        try
                        {
                          os = openFileOutput("phoneList", MODE_APPEND);
                        }
                        catch (FileNotFoundException e)
                        {
                            e.printStackTrace();
                        }
                        PrintStream ps = new PrintStream(os);
                        ps.println(Calendar.getInstance().getTime() + " 来电:" + incomingNumber);
                        Log.d("main activity", Calendar.getInstance().getTime()  + " 来电: " + incomingNumber);
                        ps.close();
                        break;
                    }
                }
                super.onCallStateChanged(state, incomingNumber);
            }
        };
        tManager.listen(listener, PhoneStateListener.LISTEN_CALL_STATE);
    }
}
