package com.example.vaith.addgesture;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    GestureOverlayView gestureOverlayView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.edit);
        gestureOverlayView = (GestureOverlayView) findViewById(R.id.gesture);

        gestureOverlayView.setGestureColor(Color.RED);

        gestureOverlayView.setGestureStrokeWidth(4);
        gestureOverlayView.addOnGesturePerformedListener(new GestureOverlayView.OnGesturePerformedListener() {
            @Override
            public void onGesturePerformed(GestureOverlayView gestureOverlayView, final Gesture gesture) {
                View saveDialog = getLayoutInflater().inflate(R.layout.save, null);
                ImageView image = (ImageView) saveDialog.findViewById(R.id.show);
                final EditText gestureName = (EditText) saveDialog.findViewById(R.id.edit);
                Bitmap bitmap = gesture.toBitmap(128, 128, 10, 0xffff0000);
                image.setImageBitmap(bitmap);
                new AlertDialog.Builder(MainActivity.this).setView(saveDialog).setPositiveButton("save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        GestureLibrary gestureLibrary = GestureLibraries.fromFile("/mnt/sdcard/mygestures");
                        gestureLibrary.addGesture(gestureName.getText().toString(), gesture);
                        gestureLibrary.save();
                    }
                }).setNegativeButton("取消", null).show();
            }
        });
    }
}
