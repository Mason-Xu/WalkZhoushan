package com.example.walkzhoushan;


import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Mason on 2017/12/14.
 */

public class StartPageActivity extends AppCompatActivity {

    private PrefManager prefManager;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);
        //设置沉浸式
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        // 判断是否第一次启动- before calling setContentView() if is the first time launch,skip the startpage
        prefManager = new PrefManager(this);
        if (prefManager.isFirstTimeLaunch()) {
            launchHomeScreen();
            finish();
        }else{
            // 设置启动页面停留2秒
            new Handler().postDelayed(new Runnable(){

                @Override
                public void run() {
                    // TODO Auto-generated method stub
                    Intent mainIntent = new Intent(StartPageActivity.this,Bottombartest.class);
                    StartPageActivity.this.startActivity(mainIntent);//跳转到MainActivity
                    StartPageActivity.this.finish();//结束SplashActivity
                }
            }, 200);//给postDelayed()方法传递延迟参数

        }

    }

    private void launchHomeScreen() {
        prefManager.setFirstTimeLaunch(false);
        startActivity(new Intent(StartPageActivity.this,Bottombartest.class));
        finish();
    }
}
