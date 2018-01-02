package com.example.walkzhoushan;

/**
 * Created by Mason on 2017/12/26.
 */

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

import com.just.agentweb.AgentWeb;
import com.just.agentweb.ChromeClientCallbackManager;

public class Home_Cate_activity extends AppCompatActivity {
    protected AgentWeb mAgentWeb;
    private AgentWeb.PreAgentWeb preAgentWeb;
    LinearLayout layout_base_web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.traffic_web);
        goToLink();
    }

    protected void goToLink() {
        layout_base_web = (LinearLayout) findViewById(R.id.layout_cate_web);
        preAgentWeb = AgentWeb.with(this)
                .setAgentWebParent(layout_base_web, new LinearLayout.LayoutParams(-1, -1))//传入AgentWeb 的父控件 ，如果父控件为 RelativeLayout ， 那么第二参数需要传入 RelativeLayout.LayoutParams ,第一个参数和第二个参数应该对应。
                .useDefaultIndicator()// 使用默认进度条
                .defaultProgressBarColor() // 使用默认进度条颜色
                .setReceivedTitleCallback(mCallback) //设置 Web 页面的 title 回调
                .createAgentWeb()//
                .ready();

        mAgentWeb = preAgentWeb.go("https://m.dianping.com/shoplist/107/d/1/c/10/s/s_-1?from=m_nav_1_meishi"); //url
    }





    public WebViewClient mWebViewClient=new WebViewClient(){
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return super.shouldOverrideUrlLoading(view, request);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return super.shouldOverrideUrlLoading(view, url);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);

        }
    };

    private WebChromeClient mWebChromeClient=new WebChromeClient(){
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
        }
    };



    private ChromeClientCallbackManager.ReceivedTitleCallback mCallback = new ChromeClientCallbackManager.ReceivedTitleCallback() {
        @Override
        public void onReceivedTitle(WebView view, final String title) {

        }
    };


    private void showDialog() {

    }




    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (mAgentWeb != null) {
            if (mAgentWeb.handleKeyEvent(keyCode, event)) {
                return true;
            }
            return super.onKeyDown(keyCode, event);
        } else  {
            return super.onKeyDown(keyCode, event);
        }
    }

    @Override
    protected void onPause() {
        if (mAgentWeb != null)
            mAgentWeb.getWebLifeCycle().onPause();
        super.onPause();

    }

    @Override
    protected void onResume() {
        if (mAgentWeb != null)
            mAgentWeb.getWebLifeCycle().onResume();
        super.onResume();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (mAgentWeb != null)
            mAgentWeb.uploadFileResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //mAgentWeb.destroy();
        if (mAgentWeb != null)
            mAgentWeb.getWebLifeCycle().onDestroy();
    }

}
