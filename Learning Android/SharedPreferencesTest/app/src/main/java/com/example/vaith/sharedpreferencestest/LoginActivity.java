package com.example.vaith.sharedpreferencestest;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Vaith on 16/8/4.
 */
public class LoginActivity extends AppCompatActivity {

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private EditText accountEditText;
    private EditText passwordEditText;
    private CheckBox rememberPasswordCheckBox;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(R.layout.login_activity);

        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        accountEditText = (EditText) findViewById(R.id.account_edit_view);
        passwordEditText = (EditText) findViewById(R.id.password_edit_view);
        rememberPasswordCheckBox = (CheckBox) findViewById(R.id.remember_pass);
        loginButton = (Button) findViewById(R.id.login);

        boolean isRemember = preferences.getBoolean("remember_password", false);
        if (isRemember)
        {
            String account = preferences.getString("account", "");
            String password = preferences.getString("password", "");
            accountEditText.setText(account);
            passwordEditText.setText(password);
            rememberPasswordCheckBox.setChecked(true);
        }

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String account = accountEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                if (account.equals("admin") && password.equals("123456"))
                {
                    editor = preferences.edit();
                    if (rememberPasswordCheckBox.isChecked())
                    {
                        editor.putBoolean("remember_password", true);
                        editor.putString("account", account);
                        editor.putString("password", password);
                    }
                    else
                    {
                        editor.clear();
                    }
                    editor.commit();

                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    Toast.makeText(LoginActivity.this, "account or password is invalid", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
