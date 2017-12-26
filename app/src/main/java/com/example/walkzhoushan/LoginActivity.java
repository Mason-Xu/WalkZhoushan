package com.example.walkzhoushan;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class LoginActivity extends BaseActivity {

    private EditText username_edit;
    private EditText password_edit;
    private Button login_button;
    private String username;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        TextView textView1 = (TextView) findViewById(R.id.login_forgetpassword);
        TextView textView2 = (TextView) findViewById(R.id.login_register);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,ForgetActivity.class);
                startActivity(intent);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
        //沉浸式状态栏
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }




        // 以下是登录验证
        Bmob.initialize(this, "cf99584b07eb1d6b3228af8fa110e524");

        username_edit = (EditText)findViewById(R.id.login_edittext_username);
        password_edit = (EditText)findViewById(R.id.login_edittext_password);


        login_button =(Button)findViewById(R.id.login_button);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BmobUser user = new BmobUser();
                username = username_edit.getText().toString();
                password = password_edit.getText().toString();
                user.setUsername(username);
                user.setPassword(password);
                user.login(new SaveListener<BmobUser>() {

                    @Override
                    public void done(BmobUser bmobUser, BmobException e) {
                        if(e==null){
                            toast("登录成功");
                            //通过BmobUser user = BmobUser.getCurrentUser()获取登录成功后的本地用户信息
                            //如果是自定义用户对象MyUser，可通过MyUser user = BmobUser.getCurrentUser(MyUser.class)获取自定义用户信息
                            //跳转主页面
                            startActivity(new Intent(LoginActivity.this,Bottombartest.class));
                        }else{
                            toast("用户名或密码错误");
                            loge(e);
                        }
                    }
                });
            }
        });
    }
}
