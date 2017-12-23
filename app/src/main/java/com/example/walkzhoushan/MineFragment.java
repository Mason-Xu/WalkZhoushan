package com.example.walkzhoushan;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Mason on 2017/12/12.
 */

public class MineFragment extends Fragment implements View.OnClickListener {

    private Button button_account;
    private Button button_phonenumber;
    private Button button_friend;
    private Button button_coupon;
    private Button button_myorder;
    private Button button_history;
    private Button button_mynote;
    private Button button_setting;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_mine_page, container, false);
        //设置按钮点击事件
        button_account = (Button) view.findViewById(R.id.button_account);
        button_phonenumber = (Button) view.findViewById(R.id.button_phonenumber);
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
        button_phonenumber.setOnClickListener(this);
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
                Intent intent1 = new Intent(getActivity(), MyInfomationActivity.class);
                startActivity(intent1);
                break;
            case R.id.button_phonenumber:
                Intent intent2 = new Intent(getActivity(), NoDevelop.class);
                startActivity(intent2);
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
