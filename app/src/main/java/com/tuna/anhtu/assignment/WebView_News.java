package com.tuna.anhtu.assignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebView_News extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_news);
        String url = "https://caodang.fpt.edu.vn/";
        webView = findViewById(R.id.WebviewNews);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);
    }
}
