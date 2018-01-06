package com.example.walkzhoushan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;

/**
 * Created by Mason on 2017/12/28.
 */

public class ChangePassword extends BaseActivity implements View.OnClickListener {

    private Button back;
    private Button certain;
    private EditText et_oldpassword;
    private EditText et_newpassword1;
    private EditText et_newpassword2;
    private String oldpassword,newpassword1,newpassword2,remote_password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.changepassword_layout);

        back = (Button)findViewById(R.id.title_button_back);
        certain = (Button)findViewById(R.id.changepassword_button_certain);
        et_oldpassword = (EditText)findViewById(R.id.oldpassword_edittext);
        et_newpassword1 = (EditText)findViewById(R.id.newpassword_edittext1);
        et_newpassword2 = (EditText)findViewById(R.id.newpassword_edittext2);

        initView();


    }

    private void initView() {
        back.setOnClickListener(this);
        certain.setOnClickListener(this);
        et_oldpassword.setOnClickListener(this);
        et_newpassword1.setOnClickListener(this);
        et_newpassword2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.title_button_back:
                onBackPressed();
                break;
            case R.id.changepassword_button_certain:
                CertainPassword();
                break;
        }
    }

    private void CertainPassword() {  // 更新密码 方法,用到Bmob后端云
        oldpassword = et_oldpassword.getText().toString();
        newpassword1 = et_newpassword1.getText().toString();
        newpassword2 = et_newpassword2.getText().toString();
        if (newpassword1.equals(newpassword2)){

            BmobUser.updateCurrentUserPassword(oldpassword, newpassword1, new UpdateListener() {

                @Override
                public void done(BmobException e) {
                    if(e==null){
                        toast("密码修改成功，可以用新密码进行登录啦");
                    }else{
                        toast("失败:" + e.getMessage());
                    }
                }

            });
        }else{
            toast("两次密码不正确");
        }
    }
}
