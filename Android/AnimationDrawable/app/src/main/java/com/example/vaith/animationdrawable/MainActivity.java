package com.example.vaith.animationdrawable;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView imageView = (ImageView) findViewById(R.id.imageview1);
        final Animation anim = AnimationUtils.loadAnimation(this, R.anim.my_anim);
        anim.setFillAfter(true);

        Button animationButton = (Button) findViewById(R.id.animation);
        assert animationButton != null;
        animationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.startAnimation(anim);
            }
        });

    }
}
