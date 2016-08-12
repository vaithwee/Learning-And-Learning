package com.example.vaith.alertdialog;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TableLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void simpleDialog(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("Title")
                .setIcon(R.mipmap.ic_launcher)
                .setMessage("message");

        setPositiveButton(builder);
        setNegativeButton(builder);
        builder.create().show();

    }

    private String[] items = new String[] {
            "java","swift","php","node.js"
    };
    public void simpleList(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("Simple List")
                .setIcon(R.mipmap.ic_launcher)
                .setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "你选择了"+i, Toast.LENGTH_SHORT).show();
                    }
                });
        setPositiveButton(builder);
        setNegativeButton(builder);
        builder.create().show();
    }


    private AlertDialog.Builder setPositiveButton(AlertDialog.Builder builder)
    {
        return builder.setPositiveButton("Sure", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Clicke sure button", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private AlertDialog.Builder setNegativeButton(AlertDialog.Builder builder)
    {
        return builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Click Cancel Button", Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void singleChoiceItems(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Single Choice Items");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setSingleChoiceItems(items, 1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "You choose " + items[i], Toast.LENGTH_SHORT).show();
            }
        });
        setPositiveButton(builder);
        setNegativeButton(builder);
        builder.create();
        builder.show();
    }


    public void multiChoiceItems(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Multi Choice Items").setIcon(R.mipmap.ic_launcher).setMultiChoiceItems(items, new boolean[] {false, false, true, true}, null);
        setNegativeButton(builder);
        setPositiveButton(builder);
        builder.create().show();
    }

    public void adapterDialog(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Custom List").setIcon(R.mipmap.ic_launcher).setAdapter(new ArrayAdapter<String>(this, R.layout.array_item, items), null);
        setPositiveButton(builder);
        setNegativeButton(builder);
        builder.create().show();
    }

    public void customView(View view)
    {
        TableLayout login = (TableLayout) getLayoutInflater().inflate(R.layout.login, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Custom View")
                .setIcon(R.mipmap.ic_launcher)
                .setView(login)
                .setPositiveButton("Login", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Login", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    }

}
