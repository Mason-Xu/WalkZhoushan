package com.example.walkzhoushan;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MessagePage extends AppCompatActivity {

    //初始化消息list
    private List<MessageUser> messageUserList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_page);
        initMessageUsers(); // 初始化聊天用户数据
        MessageAdapter adapter = new MessageAdapter(MessagePage.this, R.layout.messageuser_item, messageUserList);
        ListView listView = (ListView) findViewById(R.id.messagepage_list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MessageUser messageUser = messageUserList.get(position);
                Toast.makeText(MessagePage.this, messageUser.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    //message初始化模拟联系人数据
    private void initMessageUsers() {
        MessageUser apple = new MessageUser("Apple", R.drawable.user_img01);
        messageUserList.add(apple);
        MessageUser banana = new MessageUser("banana", R.drawable.user_img02);
        messageUserList.add(banana);
        MessageUser orange = new MessageUser("orange", R.drawable.user_img03);
        messageUserList.add(orange);
        MessageUser watermelon = new MessageUser("watermelon", R.drawable.user_img04);
        messageUserList.add(watermelon);
        MessageUser pear = new MessageUser("pear", R.drawable.user_img05);
        messageUserList.add(pear);
        MessageUser grape = new MessageUser("grape", R.drawable.user_img06);
        messageUserList.add(grape);
        MessageUser pineapple = new MessageUser("pineapple", R.drawable.user_img07);
        messageUserList.add(pineapple);
        MessageUser strawberry = new MessageUser("strawberry", R.drawable.user_img08);
        messageUserList.add(strawberry);
        MessageUser cherry = new MessageUser("cherry", R.drawable.user_img09);
        messageUserList.add(cherry);
        MessageUser mango = new MessageUser("mango", R.drawable.user_img10);
        messageUserList.add(mango);
    }

    //添加menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.addfriend,menu);
        return true;
    }

    //点击menu 添加好友事件
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add:
                Toast.makeText(this, "add friend right?", Toast.LENGTH_SHORT).show();
                break;
                default:
        }
        return true;
    }
}
