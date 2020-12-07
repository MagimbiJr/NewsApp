package com.tana.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {
    TextInputEditText mUserName, mLoginPassword;
    Button mLoginBtn, mToRegisterBtn;
    SessionManager mSessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        mUserName = findViewById(R.id.user_name);
        mLoginPassword = findViewById(R.id.login_password);
        mLoginBtn = findViewById(R.id.loginBtn);
        mToRegisterBtn = findViewById(R.id.btnToRegister);

        mSessionManager = new SessionManager(this);

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleLoginBtn();
            }
        });

        mToRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
            }
        });

        if (mSessionManager.getLogin()) {
            startActivity(new Intent(getApplicationContext(), NewsFedsActivity.class));
        }
    }

    private void handleLoginBtn() {
        String username = mUserName.getText().toString();
        String password = mLoginPassword.getText().toString();

        if (password.isEmpty()) {
            mLoginPassword.setError("You must enter your password");
           return;
        }

        if (password.equals(mLoginPassword.getText().toString())) {
            mSessionManager.setLogin(true);
            mSessionManager.setUsername(username);

            startActivity(new Intent(this, NewsFedsActivity.class));
            finish();
        } else {
            Toast.makeText(getApplicationContext(), "Wrong password", Toast.LENGTH_SHORT).show();
        }
    }
}