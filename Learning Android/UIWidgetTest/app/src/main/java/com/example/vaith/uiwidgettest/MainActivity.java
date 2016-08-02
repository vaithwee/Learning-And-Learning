package com.example.vaith.uiwidgettest;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button button;
    private EditText editText;
    private ImageView imageView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       this.button = (Button) findViewById(R.id.button);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(MainActivity.this, "Click", Toast.LENGTH_SHORT).show();
//            }
//        });

        button.setOnClickListener(this);

        this.editText = (EditText)findViewById(R.id.edittext);
        this.imageView = (ImageView) findViewById(R.id.imageview);
        this.progressBar = (ProgressBar) findViewById(R.id.progressbar);


    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.button:
//                String inputtext = editText.getText().toString();
//                Toast.makeText(this, inputtext, Toast.LENGTH_SHORT).show();
//
//                this.imageView.setImageResource(R.drawable.android);
//
//                if (this.progressBar.getVisibility() == View.GONE)
//                {
//                    this.progressBar.setVisibility(View.VISIBLE);
//                }
//                else
//                {
//                    this.progressBar.setVisibility(View.GONE);
//                }

//                int progress = this.progressBar.getProgress();
//                progress += 10;
//                this.progressBar.setProgress(progress);

                AlertDialog.Builder dialog = new AlertDialog.Builder(this);
                dialog.setTitle("This is dialog");
                dialog.setMessage("Something important");
                dialog.setCancelable(false);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener(){
                   @Override
                    public void onClick(DialogInterface dialog, int which)
                   {
                       Toast.makeText(MainActivity.this, "Ok", Toast.LENGTH_SHORT).show();
                   }
                });

                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        Toast.makeText(MainActivity.this ,"Cancel", Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();
                break;
            default:
        }
    }
}
