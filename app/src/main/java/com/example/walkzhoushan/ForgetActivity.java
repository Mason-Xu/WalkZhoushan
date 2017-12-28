package com.example.walkzhoushan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import cn.bmob.v3.BmobSMS;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.UpdateListener;

public class ForgetActivity extends BaseActivity implements View.OnClickListener {

    private Button button_back;
    private Button button_getauthcode;
    private Button button_commit;
    private EditText et_phonenumber;
    private EditText et_authcode;
    private EditText et_password1;
    private EditText et_password2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.forget_layout);

        button_back = (Button) findViewById(R.id.title_button_back);
        button_getauthcode = (Button) findViewById(R.id.forget_button_getauthcode);
        button_commit = (Button) findViewById(R.id.forget_buton_commit);
        et_phonenumber = (EditText) findViewById(R.id.forget_phonenumber);
        et_authcode = (EditText) findViewById(R.id.forget_edittext_authcode);
        et_password1= (EditText) findViewById(R.id.forget_editext_inputpassword);
        et_password2 = (EditText) findViewById(R.id.forget_editext_confirmpassword);

        initView();
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForgetActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });


    }

    private void initView() {
        button_back.setOnClickListener(this);
        button_getauthcode.setOnClickListener(this);
        button_commit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.title_button_back:
                onBackPressed();
                break;
            case R.id.forget_button_getauthcode:
                sendAuthcode();
                break;
            case R.id.forget_buton_commit:
                Commit();
                break;

            default:
                break;

        }

    }

    private void sendAuthcode() {
        // 发送短信验证码
        String phonenumber = et_phonenumber.getText().toString();
        BmobSMS.requestSMSCode(phonenumber, "舟一走忘记密码验证码",new QueryListener<Integer>() {

            @Override
            public void done(Integer smsId,BmobException ex) {
                if(ex==null){//验证码发送成功
                    Log.i("smile", "短信id："+smsId);//用于查询本次短信发送详情
                }
            }
        });
    }

    private void Commit() {
        //验证验证码和密码是否符合条件
        BmobSMS.verifySmsCode("11位手机号码", "验证码", new UpdateListener() {

            @Override
            public void done(BmobException ex) {
                if(ex==null){//短信验证码已验证成功
                    Log.i("smile", "验证通过");
                    String inputpassword=et_password1.getText().toString();
                    String confirmpassword= et_password2.getText().toString();
                    if (inputpassword.equals(confirmpassword)){
                        BmobUser newUser = new BmobUser();
                        newUser.setPassword(inputpassword);
                        BmobUser bmobUser = BmobUser.getCurrentUser();
                        newUser.update(bmobUser.getObjectId(),new UpdateListener() {
                            @Override
                            public void done(BmobException e) {
                                if(e==null){
                                    toast("更新密码成功");
                                    startActivity(new Intent(ForgetActivity.this,LoginActivity.class));
                                }else{
                                    toast("更新用户信息失败:" + e.getMessage());
                                }
                            }
                        });
                    }else {
                        toast("验证码不正确或密码两次不相同");
                    }
                }else{
                    Log.i("smile", "验证失败：code ="+ex.getErrorCode()+",msg = "+ex.getLocalizedMessage());
                }
            }
        });


    }
}
