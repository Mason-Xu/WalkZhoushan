package com.example.walkzhoushan;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Mason on 2018/1/1.
 */

public class Travelnote_Putuoshan extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.travelnote_putuoshan);
        WebView putuoshan_web = (WebView) findViewById(R.id.travelnote_putuoshan_web);
        putuoshan_web.getSettings().setJavaScriptEnabled(true);
        putuoshan_web.setWebViewClient(new WebViewClient());
        putuoshan_web.loadUrl("http://bmob-cdn-16053.b0.upaiyun.com/2018/01/01/5c32cd1a4034656280360ea8eeb16545.html");
        findViewById(R.id.title_button_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
