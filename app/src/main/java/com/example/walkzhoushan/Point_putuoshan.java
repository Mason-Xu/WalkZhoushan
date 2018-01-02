package com.example.walkzhoushan;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Mason on 2018/1/1.
 */

public class Point_putuoshan extends AppCompatActivity  {

    private Button back;
    private WebView putuoshan_web;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.point_putuoshan);
        back = (Button)findViewById(R.id.title_button_back);
        putuoshan_web = (WebView) findViewById(R.id.point_putuoshan_web);
        putuoshan_web.getSettings().setJavaScriptEnabled(true);
        putuoshan_web.setWebViewClient(new WebViewClient());
        putuoshan_web.loadUrl("http://bmob-cdn-16053.b0.upaiyun.com/2018/01/01/c556ff0a40de344280a6eefd9f04694c.html");

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
