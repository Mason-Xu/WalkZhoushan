package com.example.walkzhoushan;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mason on 2017/12/12.
 */

public class MessageFragment extends Fragment {

    //初始化消息list
    private List<MessageUser> messageUserList = new ArrayList<>();

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_message_page, container, false);
        initMessageUsers(); // 初始化聊天用户数据
        MessageAdapter adapter = new MessageAdapter(getActivity(), R.layout.messageuser_item, messageUserList);
        ListView listView = (ListView) view.findViewById(R.id.messagepage_list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MessageUser messageUser = messageUserList.get(position);
                switch (messageUser.getName()) {
                    case "舟山向导":
                        Intent intent = new Intent(getActivity(), MsgActivity.class);
                        startActivity(intent);
                        break;
                    default:
                        Toast.makeText(getActivity(), messageUser.getName(), Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        return view;
    }

    //message初始化模拟联系人数据
    private void initMessageUsers() {
        MessageUser xiangdao = new MessageUser("舟山向导", R.drawable.user_img01);
        messageUserList.add(xiangdao);
        MessageUser banana = new MessageUser("售票员", R.drawable.user_img02);
        messageUserList.add(banana);
        MessageUser orange = new MessageUser("上海旅行人", R.drawable.user_img03);
        messageUserList.add(orange);
        MessageUser watermelon = new MessageUser("Jack", R.drawable.user_img04);
        messageUserList.add(watermelon);
        MessageUser pear = new MessageUser("酒店前台", R.drawable.user_img05);
        messageUserList.add(pear);
        MessageUser grape = new MessageUser("Gren", R.drawable.user_img06);
        messageUserList.add(grape);
        MessageUser pineapple = new MessageUser("Lisa ", R.drawable.user_img07);
        messageUserList.add(pineapple);
        MessageUser strawberry = new MessageUser("Gaper", R.drawable.user_img08);
        messageUserList.add(strawberry);
        MessageUser cherry = new MessageUser("酒店前台", R.drawable.user_img09);
        messageUserList.add(cherry);
        MessageUser mango = new MessageUser("Tom", R.drawable.user_img10);
        messageUserList.add(mango);
    }
}
