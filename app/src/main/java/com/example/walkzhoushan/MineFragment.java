package com.example.walkzhoushan;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;

/**
 * Created by Mason on 2017/12/12.
 */

public class MineFragment extends Fragment implements View.OnClickListener {

    private Button button_account;
    private Button button_friend;
    private Button button_coupon;
    private Button button_myorder;
    private Button button_history;
    private Button button_mynote;
    private Button button_setting;
    private TextView phonenumber;
    private TextView mine_username;
    private TextView mail;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_mine_page, container, false);
        //设置按钮点击事件
        phonenumber = (TextView) view.findViewById(R.id.phonenumber_textview);
        ////get mobilePhoneNumber from bmob and set text for phonenumber_textview
        String phoneNumber_str = (String) BmobUser.getObjectByKey("mobilePhoneNumber");
        phonenumber.setText(phoneNumber_str);

        String username = (String) BmobUser.getObjectByKey("username");
        mine_username = (TextView) view.findViewById(R.id.mine_username_textview);
        mine_username.setText(username);

        mail = (TextView) view.findViewById(R.id.mine_usermail_textview);
        mail.setText(username+"@mail.com");


        button_account = (Button) view.findViewById(R.id.button_account);
        button_friend = (Button) view.findViewById(R.id.button_friend);
        button_coupon = (Button) view.findViewById(R.id.button_coupon);
        button_myorder = (Button) view.findViewById(R.id.button_myorder);
        button_history = (Button) view.findViewById(R.id.button_history);
        button_mynote = (Button) view.findViewById(R.id.button_mynote);
        button_setting = (Button) view.findViewById(R.id.button_setting);
        InitView();
        return view;
    }

    private void InitView() {
        button_account.setOnClickListener(this);
        button_friend.setOnClickListener(this);
        button_coupon.setOnClickListener(this);
        button_myorder.setOnClickListener(this);
        button_mynote.setOnClickListener(this);
        button_history.setOnClickListener(this);
        button_setting.setOnClickListener(this);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_account:
                BmobUser bmobUser = BmobUser.getCurrentUser();
                if(bmobUser != null){
                    // 允许用户跳转我的信息界面
                    startActivity(new Intent(getActivity(), MyInfomationActivity.class));
                }else{
                    //缓存用户对象为空时， 可打开用户注册界面…
                    startActivity(new Intent(getActivity(),LoginActivity.class));
                }
                break;
            case R.id.button_friend:
                Intent intent3 = new Intent(getActivity(), Mine_Friend.class);
                startActivity(intent3);
                break;
            case R.id.button_coupon:
                Intent intent4 = new Intent(getActivity(), Mine_Coupon_Activity.class);
                startActivity(intent4);
                break;
            case R.id.button_myorder:
                Intent intent5 = new Intent(getActivity(), MyOrder.class);
                startActivity(intent5);
                break;
            case R.id.button_history:
                Intent intent6 = new Intent(getActivity(), NoDevelop.class);
                startActivity(intent6);
                break;
            case R.id.button_mynote:
                Intent intent7 = new Intent(getActivity(), NoDevelop.class);
                startActivity(intent7);
                break;
            case R.id.button_setting:
                Intent intent8 = new Intent(getActivity(), Setting.class);
                startActivity(intent8);
                break;
            default:
                break;
        }
    }
}
