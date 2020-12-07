package com.tana.newsapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    TextView mProfFirstName, mProfLastName, mProfUserEmail;
    Button mLogoutBtn;
    SessionManager mSessionManger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Toolbar toolbar = findViewById(R.id.prof_toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        mProfFirstName = (TextView) findViewById(R.id.prof_first_name);
        mProfLastName = (TextView) findViewById(R.id.prof_last_name);
        mProfUserEmail = (TextView) findViewById(R.id.prof_user_email);
        mLogoutBtn = (Button) findViewById(R.id.logoutBtn);

        mSessionManger = new SessionManager(getApplicationContext());

        String userFirstName = mSessionManger.getFirstName();
        String userLastName = mSessionManger.getLastName();
        String userEmail = mSessionManger.getEmail();

        mProfFirstName.setText(userFirstName);
        mProfLastName.setText(userLastName);
        mProfUserEmail.setText(userEmail);

        mLogoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle("Log out");
                builder.setMessage("Are you sure to logout?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mSessionManger.setLogin(false);
                        mSessionManger.setUsername("");
                        mSessionManger.setRegPassword("");

                        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                        finish();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

    }
}