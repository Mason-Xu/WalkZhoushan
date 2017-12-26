package com.example.walkzhoushan;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.DuplicateFormatFlagsException;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by Mason on 2017/12/26.
 */

public class LoginActivityBmob extends AppCompatActivity{
    private Object QueryListener;
    private DuplicateFormatFlagsException e;
    private Object object;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);


    }

    private void toast(String s) {
        Toast.makeText(LoginActivityBmob.this,s,Toast.LENGTH_SHORT).show();
    }
}
