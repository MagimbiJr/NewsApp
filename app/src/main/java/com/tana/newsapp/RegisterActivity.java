package com.tana.newsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class RegisterActivity extends AppCompatActivity {
    TextInputEditText mFirstName, mLastName, mEmail, mPassword, mRetypePassword;
    RadioGroup mGender;
    Button mRegister;
    TextView mToLoginTxt;
    SessionManager mSessionManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mFirstName = (TextInputEditText) findViewById(R.id.etFirstName);
        mLastName = (TextInputEditText) findViewById(R.id.etLastName);
        mEmail = (TextInputEditText) findViewById(R.id.etEmail);
        mPassword = (TextInputEditText) findViewById(R.id.etPassword);
        mRetypePassword = (TextInputEditText) findViewById(R.id.etRetypePassword);
        mGender = (RadioGroup) findViewById(R.id.rgGender);
        mRegister = (Button) findViewById(R.id.registerBtn);
        mToLoginTxt = (TextView) findViewById(R.id.text_to_login);

        mSessionManager = new SessionManager(getApplicationContext());

        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleRegisterBtn();
            }
        });

        mToLoginTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            }
        });
    }

    private void handleRegisterBtn() {
        String firstName = mFirstName.getText().toString();
        String lastName = mLastName.getText().toString();
        String email = mEmail.getText().toString();
        String password = mPassword.getText().toString();
        RadioButton checkedBtn = findViewById(mGender.getCheckedRadioButtonId());
        String genderValue = checkedBtn.getText().toString();

        mSessionManager.setFirstName(firstName);
        mSessionManager.setLastName(lastName);
        mSessionManager.setEmail(email);
        mSessionManager.setRegPassword(password);
        mSessionManager.setGender(genderValue);
        Toast.makeText(getApplicationContext(), "User Saved", Toast.LENGTH_SHORT).show();
        finish();
    }
}