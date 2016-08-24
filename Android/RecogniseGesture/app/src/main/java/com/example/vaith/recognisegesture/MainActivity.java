package com.example.vaith.recognisegesture;

import android.app.AlertDialog;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.Prediction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GestureOverlayView gestureOverlayView;
    GestureLibrary gestureLibrary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gestureLibrary = GestureLibraries.fromFile("/mnt/sdcard/mygestures");
        if (gestureLibrary.load())
        {
            Toast.makeText(MainActivity.this, "Gesture File Load", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(MainActivity.this, "Gesture File Load Faill", Toast.LENGTH_SHORT).show();
        }

        gestureOverlayView = (GestureOverlayView) findViewById(R.id.gesture);
        gestureOverlayView.addOnGesturePerformedListener(new GestureOverlayView.OnGesturePerformedListener() {
            @Override
            public void onGesturePerformed(GestureOverlayView gestureOverlayView, Gesture gesture) {
                ArrayList<Prediction> predictions = gestureLibrary.recognize(gesture);
                ArrayList<String> result = new ArrayList<String>();
                for (Prediction prediction: predictions)
                {
                    if (prediction.score > 2.0)
                    {
                        result.add("gesture like [" + prediction.name + "] score is " + prediction.score);
                    }
                }
                if (result.size() > 0)
                {
                    ArrayAdapter<Object> adapter = new ArrayAdapter<Object>(MainActivity.this, android.R.layout.simple_dropdown_item_1line, result.toArray());
                    new AlertDialog.Builder(MainActivity.this).setAdapter(adapter, null).setPositiveButton("sure", null).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "no gesture", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
