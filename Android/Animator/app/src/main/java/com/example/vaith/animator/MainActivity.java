package com.example.vaith.animator;

import android.animation.AnimatorInflater;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout layout = (LinearLayout) findViewById(R.id.container);
        layout.addView(new MyAnimationView(this));
    }

    public class MyAnimationView extends View
    {
        public MyAnimationView(Context context)
        {
            super(context);
            ObjectAnimator colorAnim = (ObjectAnimator) AnimatorInflater.loadAnimator(MainActivity.this, R.animator.color_animation);
            colorAnim.setEvaluator(new ArgbEvaluator());
            colorAnim.setTarget(this);
            colorAnim.start();
        }
    }
}
