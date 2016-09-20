package com.example.vaith.audiomanager;

import android.app.Service;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    Button play, up, down;
    ToggleButton mute;
    AudioManager aManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aManager = (AudioManager) getSystemService(Service.AUDIO_SERVICE);
        play = (Button) findViewById(R.id.play);
        up = (Button) findViewById(R.id.up);
        down = (Button) findViewById(R.id.down);
        mute = (ToggleButton) findViewById(R.id.mute);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    MediaPlayer player = MediaPlayer.create(MainActivity.this, R.raw.music);
                    player.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    player.prepare();
                    player.setLooping(true);
                    player.start();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }

            }
        });
    }
}
