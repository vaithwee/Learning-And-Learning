package com.example.vaith.bundle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button regist = (Button) findViewById(R.id.regist);
        assert null != regist;
        regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText name = (EditText) findViewById(R.id.name);
                EditText password = (EditText) findViewById(R.id.password);
                RadioButton male = (RadioButton) findViewById(R.id.male);
                String gender = male.isChecked()?"男":"女";
                Person person = new Person(name.getText().toString(), password.getText().toString(), gender);
                Bundle data = new Bundle();
                data.putSerializable("person", person);
                Intent intent = new Intent(MainActivity.this, ResultAcitivity.class);
                intent.putExtras(data);
                startActivity(intent);
            }
        });
    }
}
