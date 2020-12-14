package com.tana.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class WebActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        final String webUrl = getIntent().getStringExtra("url");

        WebView webView = findViewById(R.id.web_view);
        webView.loadUrl(webUrl);

    }
}