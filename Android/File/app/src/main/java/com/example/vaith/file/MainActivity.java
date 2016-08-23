package com.example.vaith.file;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class MainActivity extends AppCompatActivity {

    final String FILE_NAME = "com.vaith.file";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println(new StringBuilder("a").append("b").append("c").toString());

        Button read = (Button) findViewById(R.id.read);
        final Button write = (Button) findViewById(R.id.write);

        final EditText editText1 = (EditText) findViewById(R.id.edit1);
        final EditText editText2 = (EditText) findViewById(R.id.edit2);

        assert write != null;
        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                assert editText1 != null;
                write(editText1.getText().toString());
                editText1.setText("");
            }
        });

        assert read != null;
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                assert editText2 != null;
                editText2.setText(read());
            }
        });

    }

    public String read()
    {
        try {
            FileInputStream fis = openFileInput(FILE_NAME);
            byte[] buff = new byte[1024];
            int hasRead = 0;
            StringBuffer stringBuffer = new StringBuffer("");
            while ((hasRead = fis.read(buff)) > 0)
            {
                stringBuffer.append(new String(buff, 0, hasRead));
            }
            fis.close();
            return stringBuffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public void write(String string)
    {
        try {
            FileOutputStream fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
            PrintStream ps = new PrintStream(fos);
            ps.println(string);
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
