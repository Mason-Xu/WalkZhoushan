package com.example.walkzhoushan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class RegisterActivity extends BaseActivity {

    private EditText username_edit;
    private EditText phonenumber_edit;
    private EditText password1_edit;
    private EditText password2_edit;
    private Button register_button;
    private CheckBox agree;
    private String username;
    private String password;
    private String password2;

    public static String TAG = "RegisterActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);
        username_edit = (EditText)findViewById(R.id.register_editext_username);
        phonenumber_edit = (EditText)findViewById(R.id.register_editext_phonenumber);
        password1_edit = (EditText)findViewById(R.id.register_editext_inputmpassword);
        password2_edit = (EditText)findViewById(R.id.register_editext_confirmpassword);
        agree = (CheckBox) findViewById(R.id.register_checkbox_agree);



        Bmob.initialize(this, "cf99584b07eb1d6b3228af8fa110e524");


        register_button = (Button)findViewById(R.id.register_buton_register);
        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BmobUser user = new BmobUser();
                username = username_edit.getText().toString();
                String phonenumber = phonenumber_edit.getText().toString();
                password = password1_edit.getText().toString();
                password2 = password2_edit.getText().toString();

                if(password2.equals(password)){  // 判断两次密码输入是否相等 相等上传数据,不相等则清除edittext
                    if(agree.isChecked()){  // 同意checkbox 选中上传数据,不同意则提示
                        user.setUsername(username);
                        user.setMobilePhoneNumber(phonenumber);
                        user.setPassword(password);
                        user.signUp(new SaveListener<MyUser>() {
                            @Override
                            public void done(MyUser s, BmobException e) {
                                if(e==null){
                                    toast("注册成功,你好 "+s.toString());
                                    Intent intent1 = new Intent(RegisterActivity.this,Bottombartest.class);
                                    startActivity(intent1);
                                }else{
                                    toast("注册失败:" +e.toString());
                                }
                            }
                        });


                    }else{
                        toast("请同意用户协议");
                    }
                }else{
                    toast("注册不成功,两次密码不同");
                    password1_edit.getText().clear();
                    password2_edit.getText().clear();
                }

            }
        });




        Button button = (Button) findViewById(R.id.title_button_back);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });
        TextView login_text = (TextView)findViewById(R.id.register_textview_sign);
        login_text.setClickable(true);
        login_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });


    }

    public static void loge(Throwable e) {
        Log.i(TAG,"===============================================================================");
        if(e instanceof BmobException){
            Log.e(TAG, "错误码："+((BmobException)e).getErrorCode()+",错误描述："+((BmobException)e).getMessage());
        }else{
            Log.e(TAG, "错误描述："+e.getMessage());
        }
    }
}
