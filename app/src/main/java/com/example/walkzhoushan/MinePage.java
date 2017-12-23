package com.example.walkzhoushan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mason on 2017/12/12.
 */

public class MinePage extends AppCompatActivity{
    //初始化我的设置list
    private List<MineSetting> mineSettingList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_page);
//        initMinesettings(); // 初始化聊天用户数据
//        MineAdapter adapter = new MineAdapter(MinePage.this, R.layout.mine_item, mineSettingList);
//        ListView listView = (ListView) findViewById(R.id.minepage_list_view);
//        listView.setAdapter(adapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                MineSetting mineSetting = mineSettingList.get(position);
//                Toast.makeText(MinePage.this, mineSetting.getSettingName(), Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    //message初始化模拟联系人数据
    private void initMinesettings() {
        MineSetting account = new MineSetting("账户管理", R.drawable.icon_accounts);
        mineSettingList.add(account);
        MineSetting phonenumber = new MineSetting("手机号码", R.drawable.icon_phone);
        mineSettingList.add(phonenumber);
        MineSetting friend = new MineSetting("好友", R.drawable.icon_friend);
        mineSettingList.add(friend);
        MineSetting coupon = new MineSetting("优惠券", R.drawable.icon_coupon);
        mineSettingList.add(coupon);
        MineSetting myorder = new MineSetting("我的订单", R.drawable.icon_myorder);
        mineSettingList.add(myorder);
        MineSetting history = new MineSetting("历史浏览", R.drawable.icon_history);
        mineSettingList.add(history);
        MineSetting mynote = new MineSetting("我的游记", R.drawable.icon_mynote);
        mineSettingList.add(mynote);
        MineSetting setting = new MineSetting("设置", R.drawable.icon_setting);
        mineSettingList.add(setting);
    }
}
