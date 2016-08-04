package com.example.vaith.broadcastbestpractice;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Vaith on 16/8/4.
 */
public class LoginViewController extends BaseViewController
{
    private EditText account;
    private EditText password;
    private Button login;

    @Override
    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(R.layout.login_view_controller);

        account = (EditText) findViewById(R.id.account);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String accountStr = account.getText().toString();
                String passwordStr = password.getText().toString();
                if (accountStr.equals("admin") && passwordStr.equals("123456"))
                {
                    Intent intent = new Intent(LoginViewController.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    Toast.makeText(LoginViewController.this, "account or password is invalid", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
