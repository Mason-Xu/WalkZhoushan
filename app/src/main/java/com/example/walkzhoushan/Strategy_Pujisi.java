package com.example.walkzhoushan;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

/**
 * Created by Mason on 2018/1/1.
 */

public class Strategy_Pujisi extends AppCompatActivity {
    private Button back;
    private WebView pujisi_web;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.strategy_pujisi);
        back = (Button)findViewById(R.id.title_button_back);
        pujisi_web = (WebView) findViewById(R.id.strategy_pujisi_web);
        pujisi_web.getSettings().setJavaScriptEnabled(true);
        pujisi_web.setWebViewClient(new WebViewClient());
        pujisi_web.loadUrl("http://bmob-cdn-16053.b0.upaiyun.com/2018/01/01/c419572d40a3a4ec8080f505925ddb22.html");

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
