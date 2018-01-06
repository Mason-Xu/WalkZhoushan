package com.example.walkzhoushan;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import cn.bmob.v3.BmobUser;

/**
 * Created by Mason on 2017/12/13.
 */

public class Setting extends BaseActivityFinishAllActivity implements View.OnClickListener {
    private Button exit;
    private Button back;
    private Button qqLink;
    private Button weChatLink;
    private Button helpLink;
    private Button about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_layout);

        back = (Button) findViewById(R.id.title_button_back);
        exit = (Button) findViewById(R.id.exitapp_button);

        initView();

    }

    private void initView() {
        back.setOnClickListener(this);
        exit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.title_button_back:
                onBackPressed();
                break;
            case R.id.exitapp_button:
                AlertDialog.Builder builder = new AlertDialog.Builder(Setting.this);
                builder.setMessage("确定退出程序?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                ActivityCollector.finishyAll();

                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Toast.makeText(Setting.this,"取消退出程序",Toast.LENGTH_SHORT).show();
                            }
                        });
                // Create the AlertDialog object and return it
                builder.show();
                break;
            default:
                break;
        }
    }


}
