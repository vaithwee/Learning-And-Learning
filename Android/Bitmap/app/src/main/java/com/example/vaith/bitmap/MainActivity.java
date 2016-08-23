package com.example.vaith.bitmap;

import android.content.res.AssetManager;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    String[] images = null;
    AssetManager assets = null;

    int currentImg = 0;

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.imageView = (ImageView) findViewById(R.id.imageContent);
        try {
            assets = getAssets();
            images = assets.list("");
        } catch (IOException e) {
            e.printStackTrace();
        }

        final Button next = (Button) findViewById(R.id.next);
        assert next != null;
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentImg >= images.length)
                {
                    currentImg = 0;
                }
                while (!images[currentImg].endsWith(".png") && !images[currentImg].endsWith(".jpg") && !images[currentImg].endsWith(".gif"))
                {
                    currentImg ++;
                    if (currentImg >= images.length)
                    {
                        currentImg = 0;
                    }
                    InputStream assetFile = null;
                    try {
                        assetFile = assets.open(images[currentImg++]);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    BitmapDrawable bitmapDrawable = (BitmapDrawable) imageView.getDrawable();
                    if (bitmapDrawable != null && !bitmapDrawable.getBitmap().isRecycled())
                    {
                        bitmapDrawable.getBitmap().recycle();
                    }
                    imageView.setImageBitmap(BitmapFactory.decodeStream(assetFile));
                }
            }
        });
    }
}
